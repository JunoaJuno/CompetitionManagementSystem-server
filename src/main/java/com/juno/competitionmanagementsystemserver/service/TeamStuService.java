package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.TeamStuMapper;
import com.juno.competitionmanagementsystemserver.model.StudentInfo;
import com.juno.competitionmanagementsystemserver.model.TeamStu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class TeamStuService extends ServiceImpl<TeamStuMapper, TeamStu> {

    public boolean saveBatch(Integer teamId, List<Integer> studentIdList) {
        List<TeamStu> teamStuList = new LinkedList<>();
        for (int i = 0; i < studentIdList.size(); i++) {
            TeamStu teamStu = new TeamStu();
            teamStu.setTeamId(teamId);
            teamStu.setStuId(studentIdList.get(i));
            teamStu.setOrder((byte) (i + 1));
            teamStuList.add(teamStu);
        }
        return saveBatch(teamStuList);
    }

    public boolean updateById(Integer teamId, List<Integer> studentIdList) {
        List<TeamStu> teamStuList =
                list(new QueryWrapper<TeamStu>().eq(TeamStu.COL_TEAM_ID, teamId).orderByAsc(TeamStu.COL_ORDER));
        List<TeamStu> teamStuListRemove = teamStuList;
        for (TeamStu teamStu : teamStuListRemove) {
            for (Integer studentId : studentIdList) {
                if (teamStu.getStuId().equals(studentId)) {
                    teamStuListRemove.remove(teamStu);
                }
            }
        }
        for (Integer studentId : studentIdList) {
            for (TeamStu teamStu : teamStuList) {
                if (teamStu.getStuId().equals(studentId)) {
                    studentIdList.remove(studentId);
                }
            }
        }
        List<Integer> removeIdList = new LinkedList<>();
        for (TeamStu teamStu : teamStuListRemove) {
            removeIdList.add(teamStu.getId());
        }
        int lastOrder = teamStuList.get(teamStuList.size()-1).getOrder();
        List<TeamStu> newTeamStuList = new LinkedList<>();
        for (int i = 0; i < studentIdList.size(); i++) {
            TeamStu teamStu = new TeamStu();
            teamStu.setTeamId(teamId);
            teamStu.setStuId(studentIdList.get(i));
            teamStu.setOrder((byte) (lastOrder + i + 1));
            teamStuList.add(teamStu);
        }
        if (removeByIds(removeIdList) && saveBatch(newTeamStuList)) {
            return true;
        } else {
            throw new RuntimeException("更新失败，回滚!");
        }
    }
}
