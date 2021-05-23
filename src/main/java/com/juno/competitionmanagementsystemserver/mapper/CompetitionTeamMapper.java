package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionTeam;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompetitionTeamMapper extends BaseMapper<CompetitionTeam> {
    int updateBatch(List<CompetitionTeam> list);

    int updateBatchSelective(List<CompetitionTeam> list);

    int batchInsert(@Param("list") List<CompetitionTeam> list);

    int insertOrUpdate(CompetitionTeam record);

    int insertOrUpdateSelective(CompetitionTeam record);
}