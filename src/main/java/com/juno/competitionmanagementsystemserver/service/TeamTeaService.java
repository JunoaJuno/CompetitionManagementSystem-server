package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.juno.competitionmanagementsystemserver.model.TeamTea;
import com.juno.competitionmanagementsystemserver.mapper.TeamTeaMapper;
@Service
public class TeamTeaService extends ServiceImpl<TeamTeaMapper, TeamTea> {

    
    public int updateBatch(List<TeamTea> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<TeamTea> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<TeamTea> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(TeamTea record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(TeamTea record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
