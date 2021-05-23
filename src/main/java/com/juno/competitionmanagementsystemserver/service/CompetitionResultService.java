package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.model.CompetitionResult;
import java.util.List;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionResultMapper;
@Service
public class CompetitionResultService extends ServiceImpl<CompetitionResultMapper, CompetitionResult> {

    
    public int updateBatch(List<CompetitionResult> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<CompetitionResult> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<CompetitionResult> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(CompetitionResult record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(CompetitionResult record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
