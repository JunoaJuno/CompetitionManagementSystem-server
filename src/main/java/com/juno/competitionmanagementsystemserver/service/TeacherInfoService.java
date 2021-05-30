package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.dto.TeacherInfoDto;
import com.juno.competitionmanagementsystemserver.mapper.TeacherInfoMapper;
import com.juno.competitionmanagementsystemserver.model.TeacherInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherInfoService extends ServiceImpl<TeacherInfoMapper, TeacherInfo> {

    public boolean save(TeacherInfoDto teacherInfoDto) {
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setId(teacherInfoDto.getId());
        teacherInfo.setName(teacherInfoDto.getName());
        teacherInfo.setPosition(teacherInfoDto.getPosition());
        teacherInfo.setEmail(teacherInfoDto.getEmail());
        teacherInfo.setSex(teacherInfoDto.getSex());
        teacherInfo.setTelephone(teacherInfoDto.getTelephone());
        return save(teacherInfo);
    }

    public boolean updateById(TeacherInfoDto teacherInfoDto) {
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setId(teacherInfoDto.getId());
        teacherInfo.setName(teacherInfoDto.getName());
        teacherInfo.setPosition(teacherInfoDto.getPosition());
        teacherInfo.setEmail(teacherInfoDto.getEmail());
        teacherInfo.setSex(teacherInfoDto.getSex());
        teacherInfo.setTelephone(teacherInfoDto.getTelephone());
        return updateById(teacherInfo);
    }
}
