package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompetitionInfoMapper extends BaseMapper<CompetitionInfo> {
    int updateBatch(List<CompetitionInfo> list);

    int updateBatchSelective(List<CompetitionInfo> list);

    int batchInsert(@Param("list") List<CompetitionInfo> list);

    int insertOrUpdate(CompetitionInfo record);

    int insertOrUpdateSelective(CompetitionInfo record);
}