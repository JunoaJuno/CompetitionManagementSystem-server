package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.TeamTea;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamTeaMapper extends BaseMapper<TeamTea> {
    int updateBatch(List<TeamTea> list);

    int updateBatchSelective(List<TeamTea> list);

    int batchInsert(@Param("list") List<TeamTea> list);

    int insertOrUpdate(TeamTea record);

    int insertOrUpdateSelective(TeamTea record);
}