package com.juno.competitionmanagementsystemserver.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juno.competitionmanagementsystemserver.model.StudentInfo;
import com.juno.competitionmanagementsystemserver.mapper.StudentInfoMapper;
@Service
public class StudentInfoService extends ServiceImpl<StudentInfoMapper, StudentInfo> {

}
