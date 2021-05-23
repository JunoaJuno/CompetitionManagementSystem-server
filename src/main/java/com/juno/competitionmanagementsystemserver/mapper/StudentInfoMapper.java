package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.StudentInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {
    int updateBatch(List<StudentInfo> list);

    int updateBatchSelective(List<StudentInfo> list);

    int batchInsert(@Param("list") List<StudentInfo> list);

    int insertOrUpdate(StudentInfo record);

    int insertOrUpdateSelective(StudentInfo record);
}