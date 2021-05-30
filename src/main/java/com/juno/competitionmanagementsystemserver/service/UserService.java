package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.UserMapper;
import com.juno.competitionmanagementsystemserver.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper, User> {

}
