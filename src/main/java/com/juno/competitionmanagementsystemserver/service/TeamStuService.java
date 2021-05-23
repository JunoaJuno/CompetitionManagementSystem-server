package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.model.TeamStu;
import java.util.List;
import com.juno.competitionmanagementsystemserver.mapper.TeamStuMapper;
@Service
public class TeamStuService extends ServiceImpl<TeamStuMapper, TeamStu> {

    
    public int updateBatch(List<TeamStu> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<TeamStu> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<TeamStu> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(TeamStu record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(TeamStu record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
