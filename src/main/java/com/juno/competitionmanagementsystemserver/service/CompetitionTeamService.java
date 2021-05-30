package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.dto.CompetitionTeamDto;
import com.juno.competitionmanagementsystemserver.mapper.CompetitionTeamMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionTeam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompetitionTeamService extends ServiceImpl<CompetitionTeamMapper, CompetitionTeam> {

    public CompetitionTeam save(CompetitionTeamDto competitionTeamDto) {
        CompetitionTeam competitionTeam = new CompetitionTeam();
        competitionTeam.setComment(competitionTeamDto.getComment());
        competitionTeam.setCompetitionId(competitionTeamDto.getCompetitionId());
        competitionTeam.setName(competitionTeamDto.getName());
        competitionTeam.setIsRegistrationReviewPass((byte) 2);
        competitionTeam.setRaceTrackId(competitionTeamDto.getRaceTrackId());
        return save(competitionTeam) ? competitionTeam : null;
    }

    public CompetitionTeam updateById(Integer id, CompetitionTeamDto competitionTeamDto) {
        CompetitionTeam competitionTeam = new CompetitionTeam();
        competitionTeam.setId(id);
        competitionTeam.setComment(competitionTeamDto.getComment());
        competitionTeam.setCompetitionId(competitionTeamDto.getCompetitionId());
        competitionTeam.setName(competitionTeamDto.getName());
        competitionTeam.setIsRegistrationReviewPass((byte) 2);
        competitionTeam.setRaceTrackId(competitionTeamDto.getRaceTrackId());
        return updateById(competitionTeam) ? competitionTeam : null;
    }
}

