package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.juno.competitionmanagementsystemserver.model.CompetitionMasterInfo;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionMasterInfoMapper;
@Service
public class CompetitionMasterInfoService extends ServiceImpl<CompetitionMasterInfoMapper, CompetitionMasterInfo> {

    
    public int updateBatch(List<CompetitionMasterInfo> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<CompetitionMasterInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<CompetitionMasterInfo> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(CompetitionMasterInfo record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(CompetitionMasterInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
