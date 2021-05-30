package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.TeamTeaMapper;
import com.juno.competitionmanagementsystemserver.model.TeamTea;
import com.juno.competitionmanagementsystemserver.model.TeamTea;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class TeamTeaService extends ServiceImpl<TeamTeaMapper, TeamTea> {
    public boolean saveBatch(Integer teamId, List<Integer> teacherIdList) {
        List<TeamTea> teamTeaList = new LinkedList<>();
        for (int i = 0; i < teacherIdList.size(); i++) {
            TeamTea teamTea = new TeamTea();
            teamTea.setTeamId(teamId);
            teamTea.setTeaId(teacherIdList.get(i));
            teamTea.setOrder((byte) (i + 1));
            teamTeaList.add(teamTea);
        }
        return saveBatch(teamTeaList);
    }

    public boolean updateById(Integer teamId, List<Integer> teacherIdList) {
        List<TeamTea> teamTeaList =
                list(new QueryWrapper<TeamTea>().eq(TeamTea.COL_TEAM_ID, teamId).orderByAsc(TeamTea.COL_ORDER));
        List<TeamTea> teamTeaListRemove = teamTeaList;
        for (TeamTea teamTea : teamTeaListRemove) {
            for (Integer teacherId : teacherIdList) {
                if (teamTea.getTeaId().equals(teacherId)) {
                    teamTeaListRemove.remove(teamTea);
                }
            }
        }
        for (Integer teacherId : teacherIdList) {
            for (TeamTea teamTea : teamTeaList) {
                if (teamTea.getTeaId().equals(teacherId)) {
                    teacherIdList.remove(teacherId);
                }
            }
        }
        List<Integer> removeIdList = new LinkedList<>();
        for (TeamTea teamTea : teamTeaListRemove) {
            removeIdList.add(teamTea.getId());
        }
        int lastOrder = teamTeaList.get(teamTeaList.size()-1).getOrder();
        List<TeamTea> newTeamTeaList = new LinkedList<>();
        for (int i = 0; i < teacherIdList.size(); i++) {
            TeamTea teamTea = new TeamTea();
            teamTea.setTeamId(teamId);
            teamTea.setTeaId(teacherIdList.get(i));
            teamTea.setOrder((byte) (lastOrder + i + 1));
            teamTeaList.add(teamTea);
        }
        if (removeByIds(removeIdList) && saveBatch(newTeamTeaList)) {
            return true;
        } else {
            throw new RuntimeException("更新失败，回滚!");
        }
    }
}
