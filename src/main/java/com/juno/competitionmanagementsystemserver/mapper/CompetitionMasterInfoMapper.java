package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.CompetitionMasterInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompetitionMasterInfoMapper extends BaseMapper<CompetitionMasterInfo> {
    int updateBatch(List<CompetitionMasterInfo> list);

    int updateBatchSelective(List<CompetitionMasterInfo> list);

    int batchInsert(@Param("list") List<CompetitionMasterInfo> list);

    int insertOrUpdate(CompetitionMasterInfo record);

    int insertOrUpdateSelective(CompetitionMasterInfo record);
}