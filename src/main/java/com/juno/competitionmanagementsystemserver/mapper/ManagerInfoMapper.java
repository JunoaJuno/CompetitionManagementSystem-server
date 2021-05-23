package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.ManagerInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerInfoMapper extends BaseMapper<ManagerInfo> {
    int updateBatch(List<ManagerInfo> list);

    int updateBatchSelective(List<ManagerInfo> list);

    int batchInsert(@Param("list") List<ManagerInfo> list);

    int insertOrUpdate(ManagerInfo record);

    int insertOrUpdateSelective(ManagerInfo record);
}