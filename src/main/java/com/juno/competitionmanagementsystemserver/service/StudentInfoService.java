package com.juno.competitionmanagementsystemserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.dto.StudentInfoDto;
import com.juno.competitionmanagementsystemserver.mapper.StudentInfoMapper;
import com.juno.competitionmanagementsystemserver.model.StudentInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentInfoService extends ServiceImpl<StudentInfoMapper, StudentInfo> {

    public boolean save(StudentInfoDto studentInfoDto) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(studentInfoDto.getId());
        studentInfo.setName(studentInfoDto.getName());
        studentInfo.setClassId(studentInfoDto.getClassId());
        studentInfo.setEmail(studentInfoDto.getEmail());
        studentInfo.setFaculty(studentInfoDto.getFaculty());
        studentInfo.setSex(studentInfoDto.getSex());
        studentInfo.setMajor(studentInfoDto.getMajor());
        studentInfo.setTelephone(studentInfoDto.getTelephone());
        return save(studentInfo);
    }

    public boolean updateById(StudentInfoDto studentInfoDto) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(studentInfo.getId());
        studentInfo.setName(studentInfoDto.getName());
        studentInfo.setClassId(studentInfoDto.getClassId());
        studentInfo.setEmail(studentInfoDto.getEmail());
        studentInfo.setFaculty(studentInfoDto.getFaculty());
        studentInfo.setSex(studentInfoDto.getSex());
        studentInfo.setMajor(studentInfoDto.getMajor());
        studentInfo.setTelephone(studentInfoDto.getTelephone());
        return updateById(studentInfo);
    }
}
