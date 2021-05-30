package com.juno.competitionmanagementsystemserver.service;

import com.juno.competitionmanagementsystemserver.model.AuthUserDetails;
import com.juno.competitionmanagementsystemserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDetailsServiceCustomize implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public AuthUserDetails loadUserByUsername(String var1) throws UsernameNotFoundException {
        User user = userService.getById(Integer.valueOf(var1));
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        } else {
            return new AuthUserDetails(user.getNickname(), user.getPassword(), user.getId(),
                    user.getManageId().toString());
        }
    }
}
