package com.juno.competitionmanagementsystemserver.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juno.competitionmanagementsystemserver.model.AuthUserDetails;
import com.juno.competitionmanagementsystemserver.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Base64;

@Component
public class UserDetailsServiceCustomize implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public AuthUserDetails loadUserByUsername(String var1) throws UsernameNotFoundException {
        String data = new String(Base64.getDecoder().decode(var1));
        JSONObject jsonObject = JSON.parseObject(data);
        Integer id = jsonObject.getInteger("userId");
        User user = userService.getById(id);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        } else {
            if (jsonObject.containsKey("isPreLogin")) {
                return new AuthUserDetails(user.getNickname(), user.getPassword(), user.getId(),
                        user.getSessionKey(), user.getOpenId(), "PRE_LOGIN");
            } else {
                return new AuthUserDetails(user.getNickname(), user.getPassword(), user.getId(),
                        user.getSessionKey(), user.getOpenId(), user.getManageId().toString());
            }
        }
    }
}
