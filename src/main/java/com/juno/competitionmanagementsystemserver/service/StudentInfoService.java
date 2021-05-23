package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.juno.competitionmanagementsystemserver.model.StudentInfo;
import com.juno.competitionmanagementsystemserver.mapper.StudentInfoMapper;
@Service
public class StudentInfoService extends ServiceImpl<StudentInfoMapper, StudentInfo> {

    
    public int updateBatch(List<StudentInfo> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<StudentInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<StudentInfo> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(StudentInfo record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(StudentInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
