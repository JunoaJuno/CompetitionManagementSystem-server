package com.juno.competitionmanagementsystemserver.service;

import com.juno.competitionmanagementsystemserver.dto.StudentInfoDto;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.model.StudentInfo;
import com.juno.competitionmanagementsystemserver.mapper.StudentInfoMapper;
@Service
public class StudentInfoService extends ServiceImpl<StudentInfoMapper, StudentInfo> {

    public boolean save(StudentInfoDto studentInfoDto) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setName(studentInfoDto.getName());
        studentInfo.setClassId(studentInfoDto.getClassId());
        studentInfo.setEmail(studentInfoDto.getEmail());
        studentInfo.setFaculty(studentInfoDto.getFaculty());
        studentInfo.setSex(studentInfoDto.getSex());
        studentInfo.setMajor(studentInfoDto.getMajor());
        studentInfo.setTelephone(studentInfoDto.getTelephone());
        return save(studentInfoDto);
    }
}
