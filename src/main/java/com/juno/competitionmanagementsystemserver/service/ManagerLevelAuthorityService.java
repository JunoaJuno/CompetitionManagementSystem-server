package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.juno.competitionmanagementsystemserver.model.ManagerLevelAuthority;
import com.juno.competitionmanagementsystemserver.mapper.ManagerLevelAuthorityMapper;
@Service
public class ManagerLevelAuthorityService extends ServiceImpl<ManagerLevelAuthorityMapper, ManagerLevelAuthority> {

    
    public int updateBatch(List<ManagerLevelAuthority> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<ManagerLevelAuthority> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<ManagerLevelAuthority> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(ManagerLevelAuthority record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(ManagerLevelAuthority record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
