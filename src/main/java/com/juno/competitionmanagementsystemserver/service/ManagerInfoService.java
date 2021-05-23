package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.juno.competitionmanagementsystemserver.mapper.ManagerInfoMapper;
import com.juno.competitionmanagementsystemserver.model.ManagerInfo;
@Service
public class ManagerInfoService extends ServiceImpl<ManagerInfoMapper, ManagerInfo> {

    
    public int updateBatch(List<ManagerInfo> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<ManagerInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<ManagerInfo> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(ManagerInfo record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(ManagerInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
