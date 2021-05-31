package com.juno.competitionmanagementsystemserver.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionTeam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompetitionTeamMapper extends BaseMapper<CompetitionTeam> {
    List<CompetitionTeam> findByAll(CompetitionTeam competitionTeam);

//    List<Object> findTest();

}