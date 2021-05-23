package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.WorkInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkInfoMapper extends BaseMapper<WorkInfo> {
    int updateBatch(List<WorkInfo> list);

    int updateBatchSelective(List<WorkInfo> list);

    int batchInsert(@Param("list") List<WorkInfo> list);

    int insertOrUpdate(WorkInfo record);

    int insertOrUpdateSelective(WorkInfo record);

    int insertOrUpdateWithBLOBs(WorkInfo record);
}