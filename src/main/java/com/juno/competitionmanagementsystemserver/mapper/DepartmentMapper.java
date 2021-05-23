package com.juno.competitionmanagementsystemserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juno.competitionmanagementsystemserver.model.Department;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    int updateBatch(List<Department> list);

    int updateBatchSelective(List<Department> list);

    int batchInsert(@Param("list") List<Department> list);

    int insertOrUpdate(Department record);

    int insertOrUpdateSelective(Department record);
}