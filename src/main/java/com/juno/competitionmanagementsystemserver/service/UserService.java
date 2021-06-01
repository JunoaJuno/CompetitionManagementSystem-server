package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.dto.UserInfoDto;
import com.juno.competitionmanagementsystemserver.mapper.UserMapper;
import com.juno.competitionmanagementsystemserver.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper, User> {


    public User saveOrUpdate(UserInfoDto userInfoDto, String sessionKey, String openid,
                                UpdateWrapper<User> updateWrapper) {
        User user = getOne(new QueryWrapper<User>().eq(User.COL_OPEN_ID, openid));
        if (user == null) {
            user = new User();
        }
        user.setAvatarurl(userInfoDto.getAvatarUrl());
        user.setCity(userInfoDto.getCity());
        user.setCountry(userInfoDto.getCountry());
        user.setGender(userInfoDto.getGender());
        user.setLanguage(userInfoDto.getLanguage());
        user.setNickname(userInfoDto.getNickName());
        user.setOpenId(openid);
        user.setSessionKey(sessionKey);
        user.setProvince(userInfoDto.getProvince());
        user.setPassword(UUID.randomUUID().toString());
        return saveOrUpdate(user, updateWrapper) ? user : null;
    }

    public User updateById(Integer id, String phoneNumber) {
        User user = getById(id);
        user.setPhone(phoneNumber);
        return updateById(user)? user : null;
    }
}
