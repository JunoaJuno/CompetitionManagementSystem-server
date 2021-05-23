package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionResult;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompetitionResultMapper extends BaseMapper<CompetitionResult> {
    int updateBatch(List<CompetitionResult> list);

    int updateBatchSelective(List<CompetitionResult> list);

    int batchInsert(@Param("list") List<CompetitionResult> list);

    int insertOrUpdate(CompetitionResult record);

    int insertOrUpdateSelective(CompetitionResult record);
}