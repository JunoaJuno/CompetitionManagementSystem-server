package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionTeamMapper;
import java.util.List;
import com.juno.competitionmanagementsystemserver.model.CompetitionTeam;
@Service
public class CompetitionTeamService extends ServiceImpl<CompetitionTeamMapper, CompetitionTeam> {

    
    public int updateBatch(List<CompetitionTeam> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<CompetitionTeam> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<CompetitionTeam> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(CompetitionTeam record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(CompetitionTeam record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
