package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.UserMapper;
import com.juno.competitionmanagementsystemserver.model.User;
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
