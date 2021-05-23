package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.mapper.TeacherInfoMapper;
import java.util.List;
import com.juno.competitionmanagementsystemserver.model.TeacherInfo;
@Service
public class TeacherInfoService extends ServiceImpl<TeacherInfoMapper, TeacherInfo> {

    
    public int updateBatch(List<TeacherInfo> list) {
        return baseMapper.updateBatch(list);
    }
    
    public int updateBatchSelective(List<TeacherInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    
    public int batchInsert(List<TeacherInfo> list) {
        return baseMapper.batchInsert(list);
    }
    
    public int insertOrUpdate(TeacherInfo record) {
        return baseMapper.insertOrUpdate(record);
    }
    
    public int insertOrUpdateSelective(TeacherInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
