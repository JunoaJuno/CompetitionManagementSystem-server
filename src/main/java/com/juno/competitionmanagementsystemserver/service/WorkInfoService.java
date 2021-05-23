package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.juno.competitionmanagementsystemserver.mapper.WorkInfoMapper;
import com.juno.competitionmanagementsystemserver.model.WorkInfo;
@Service
public class WorkInfoService extends ServiceImpl<WorkInfoMapper, WorkInfo> {

    
    public int updateBatch(List<WorkInfo> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<WorkInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<WorkInfo> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(WorkInfo record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(WorkInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
    
    public int insertOrUpdateWithBLOBs(WorkInfo record) {
        return baseMapper.insertOrUpdateWithBLOBs(record);
    }
}
