package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.TeamStu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamStuMapper extends BaseMapper<TeamStu> {
    int updateBatch(List<TeamStu> list);

    int updateBatchSelective(List<TeamStu> list);

    int batchInsert(@Param("list") List<TeamStu> list);

    int insertOrUpdate(TeamStu record);

    int insertOrUpdateSelective(TeamStu record);
}