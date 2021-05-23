package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.juno.competitionmanagementsystemserver.mapper.DepartmentMapper;
import com.juno.competitionmanagementsystemserver.model.Department;
@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {

    
    public int updateBatch(List<Department> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<Department> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<Department> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(Department record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(Department record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
