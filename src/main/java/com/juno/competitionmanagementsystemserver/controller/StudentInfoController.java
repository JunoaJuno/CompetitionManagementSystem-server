package com.juno.competitionmanagementsystemserver.controller;

import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import com.juno.competitionmanagementsystemserver.dto.StudentInfoDto;
import com.juno.competitionmanagementsystemserver.service.StudentInfoService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "学生信息")
@Controller
@CrossOrigin
@RequestMapping(value = {"/api/v1/student/info"})
public class StudentInfoController {

    private final StudentInfoService studentInfoService;

    public StudentInfoController(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    @PutMapping()
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> addStudentInfo(@RequestBody StudentInfoDto studentInfoDto) {
        if (studentInfoService.save(studentInfoDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStruct<>("ok", ""));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

}
