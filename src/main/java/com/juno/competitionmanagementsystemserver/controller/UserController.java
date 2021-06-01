package com.juno.competitionmanagementsystemserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.juno.competitionmanagementsystemserver.config.WxConfig;
import com.juno.competitionmanagementsystemserver.dto.PhoneDto;
import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import com.juno.competitionmanagementsystemserver.dto.UserInfoDto;
import com.juno.competitionmanagementsystemserver.model.AuthUserDetails;
import com.juno.competitionmanagementsystemserver.model.User;
import com.juno.competitionmanagementsystemserver.service.UserService;
import com.juno.competitionmanagementsystemserver.utils.JwtUtils;
import com.juno.competitionmanagementsystemserver.utils.WxPhoneUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;


@Api(tags = "用户")
@Controller
@CrossOrigin
@RequestMapping(value = {"/api/v1/user"})
@Slf4j
public class UserController {

    private final WxConfig wxConfig;

    private final UserService userService;

    public UserController(WxConfig wxConfig, UserService userService) {
        this.wxConfig = wxConfig;
        this.userService = userService;
    }

    @PostMapping(value = "preLogin/{code}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> preLogin(@RequestBody UserInfoDto userInfoDto,
                                                           @NotBlank
                                                           @PathVariable String code) {
        String sessionKey = "";
        String openid = "";
        try {
            Content content =
                    Request.Get("https://api.weixin.qq.com/sns/jscode2session?appid="+wxConfig.getMiniProgram().getAppid()+
                            "&secret" +
                    "="+wxConfig.getMiniProgram().getSecret()+"&js_code="+code+"&grant_type" +
                            "=authorization_code").execute().returnContent();
            JSONObject resultJson = JSON.parseObject(content.asString(Consts.UTF_8));
            if (resultJson.getString("errmsg") == null) {
                sessionKey = resultJson.getString("session_key");
                openid = resultJson.getString("openid");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", "登录失败"));
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        User user = userService.saveOrUpdate(userInfoDto, sessionKey, openid,
                new UpdateWrapper<User>().eq(User.COL_OPEN_ID,
                openid));
        if (user != null) {
            String preLoginToken = JwtUtils.getPreToken(user);
            return ResponseEntity.status(HttpStatus.OK).header("Authorization", "Bearer " + preLoginToken).body(new ResponseStruct<>("ok", "预登录"));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", "登录失败"));
        }
    }

    @PreAuthorize("hasAuthority('PRE_LOGIN')")
    @PostMapping(value = "login")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> login(@RequestBody PhoneDto phoneDto) {
        AuthUserDetails userDetails = (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String phone = WxPhoneUtil.decryptData(phoneDto.getEncryptedData(), userDetails.getSessionKey(), phoneDto.getIv());
        JSONObject jsonObject = JSON.parseObject(phone);
        User user = userService.updateById(userDetails.getUserId(), jsonObject.getString("phoneNumber"));
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).header("Authorization",
                    "Bearer " + JwtUtils.getToken(user)).body(new ResponseStruct<>("ok",
                    "登录成功"));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }

    }
}
