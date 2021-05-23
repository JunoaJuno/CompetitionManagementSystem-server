package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.TeacherInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherInfoMapper extends BaseMapper<TeacherInfo> {
    int updateBatch(List<TeacherInfo> list);

    int updateBatchSelective(List<TeacherInfo> list);

    int batchInsert(@Param("list") List<TeacherInfo> list);

    int insertOrUpdate(TeacherInfo record);

    int insertOrUpdateSelective(TeacherInfo record);
}