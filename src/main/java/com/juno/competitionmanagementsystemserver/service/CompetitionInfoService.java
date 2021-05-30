package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.dto.CompetitionSlaveDto;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionInfoMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class CompetitionInfoService extends ServiceImpl<CompetitionInfoMapper, CompetitionInfo> {

    public boolean saveBatch(Integer masterId, List<CompetitionSlaveDto> competitionSlaveDtoList) {
        List<CompetitionInfo> storageCompetitionInfoList = getByMasterId(masterId);
        int indexStart = 1;
        if (storageCompetitionInfoList.size() > 0) {
            indexStart += storageCompetitionInfoList.get(storageCompetitionInfoList.size() - 1).getOrder();
        }
        List<CompetitionInfo> competitionInfoList = new LinkedList<>();
        for (int i = 0; i < competitionSlaveDtoList.size(); i++) {
            CompetitionInfo competitionInfo = new CompetitionInfo();
            competitionInfo.setCommId(masterId);
            competitionInfo.setDescription(competitionSlaveDtoList.get(i).getDescription());
            competitionInfo.setLevel(competitionSlaveDtoList.get(i).getLevel());
            competitionInfo.setLocation(competitionSlaveDtoList.get(i).getLocation());
            competitionInfo.setName(competitionSlaveDtoList.get(i).getName());
            competitionInfo.setOrder(indexStart + i);
            competitionInfo.setSignupEnd(competitionSlaveDtoList.get(i).getSignupEnd());
            competitionInfo.setSignupStart(competitionSlaveDtoList.get(i).getSignupStart());
            competitionInfo.setSponsor(competitionSlaveDtoList.get(i).getSponsor());
            competitionInfo.setState(competitionSlaveDtoList.get(i).getState());
            competitionInfo.setUndertaker(competitionSlaveDtoList.get(i).getUndertaker());
            competitionInfo.setWorksEnd(competitionSlaveDtoList.get(i).getWorksEnd());
            competitionInfoList.add(competitionInfo);
        }
        return saveBatch(competitionInfoList);
    }

    public List<CompetitionInfo> getByMasterId(Integer masterId) {
        QueryWrapper<CompetitionInfo> competitionInfoQueryWrapper = new QueryWrapper<>();
        competitionInfoQueryWrapper.eq(CompetitionInfo.COL_COMM_ID, masterId).orderByAsc("`order`");
        return list(competitionInfoQueryWrapper);
    }

    public boolean updateById(Integer id, CompetitionSlaveDto competitionSlaveDto) {
        CompetitionInfo competitionInfo = new CompetitionInfo();
        competitionInfo.setId(id);
        competitionInfo.setDescription(competitionSlaveDto.getDescription());
        competitionInfo.setLevel(competitionSlaveDto.getLevel());
        competitionInfo.setLocation(competitionSlaveDto.getLocation());
        competitionInfo.setName(competitionSlaveDto.getName());
        competitionInfo.setSignupEnd(competitionSlaveDto.getSignupEnd());
        competitionInfo.setSignupStart(competitionSlaveDto.getSignupStart());
        competitionInfo.setSponsor(competitionSlaveDto.getSponsor());
        competitionInfo.setState(competitionSlaveDto.getState());
        competitionInfo.setUndertaker(competitionSlaveDto.getUndertaker());
        competitionInfo.setWorksEnd(competitionSlaveDto.getWorksEnd());
        return updateById(competitionInfo);
    }
}

