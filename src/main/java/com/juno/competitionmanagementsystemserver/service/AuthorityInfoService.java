package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.juno.competitionmanagementsystemserver.mapper.AuthorityInfoMapper;
import com.juno.competitionmanagementsystemserver.model.AuthorityInfo;
@Service
public class AuthorityInfoService extends ServiceImpl<AuthorityInfoMapper, AuthorityInfo> {

    
    public int updateBatch(List<AuthorityInfo> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<AuthorityInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<AuthorityInfo> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(AuthorityInfo record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(AuthorityInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
