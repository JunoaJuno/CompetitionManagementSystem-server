package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.UserMapper;
import java.util.List;
import com.juno.competitionmanagementsystemserver.model.User;
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    
    public int updateBatch(List<User> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<User> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<User> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(User record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(User record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
