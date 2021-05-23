package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionInfoMapper;
import java.util.List;
import com.juno.competitionmanagementsystemserver.model.CompetitionInfo;
@Service
public class CompetitionInfoService extends ServiceImpl<CompetitionInfoMapper, CompetitionInfo> {

    
    public int updateBatch(List<CompetitionInfo> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<CompetitionInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<CompetitionInfo> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(CompetitionInfo record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(CompetitionInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
