package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.dto.CompetitionMasterDto;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionMasterInfoMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionMasterInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompetitionMasterInfoService extends ServiceImpl<CompetitionMasterInfoMapper, CompetitionMasterInfo> {

    public boolean addNewCompMaster(CompetitionMasterDto dto) {
        CompetitionMasterInfo competitionMasterInfo = new CompetitionMasterInfo();
        competitionMasterInfo.setName(dto.getName());
        competitionMasterInfo.setType(dto.getType());
        competitionMasterInfo.setRaceTrack(dto.getRaceTrack());
        competitionMasterInfo.setDescription(dto.getDescription());
        competitionMasterInfo.setYear(dto.getYear());
        return save(competitionMasterInfo);
    }

    public boolean updateById(Integer id, CompetitionMasterDto dto) {
        CompetitionMasterInfo competitionMasterInfo = new CompetitionMasterInfo();
        competitionMasterInfo.setId(id);
        competitionMasterInfo.setName(dto.getName());
        competitionMasterInfo.setType(dto.getType());
        competitionMasterInfo.setRaceTrack(dto.getRaceTrack());
        competitionMasterInfo.setDescription(dto.getDescription());
        competitionMasterInfo.setYear(dto.getYear());
        return updateById(competitionMasterInfo);
    }

    public boolean has(Integer id) {
        CompetitionMasterInfo competitionMasterInfo = getById(id);
        return competitionMasterInfo != null;
    }
}
