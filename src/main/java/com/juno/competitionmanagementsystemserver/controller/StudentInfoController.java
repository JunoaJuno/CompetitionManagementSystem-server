package com.juno.competitionmanagementsystemserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import com.juno.competitionmanagementsystemserver.dto.StudentInfoDto;
import com.juno.competitionmanagementsystemserver.model.StudentInfo;
import com.juno.competitionmanagementsystemserver.service.StudentInfoService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

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
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @PostMapping()
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> changeStudentInfo(@RequestBody StudentInfoDto studentInfoDto) {
        if (studentInfoService.updateById(studentInfoDto)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> deleteStudentInfo(@Digits(integer = 10, fraction = 0)
                                                                    @Positive
                                                                    @PathVariable
                                                                            Integer id) {
        if (studentInfoService.removeById(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<StudentInfo>> getStudentInfo(@Digits(integer = 10, fraction = 0)
                                                                      @Positive
                                                                      @PathVariable
                                                                              Integer id) {
        StudentInfo studentInfo = studentInfoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", studentInfo));
    }

    @GetMapping(value = "/list")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<Page<StudentInfo>>> getStudentInfoList(@Digits(integer = 4, fraction = 0,
            message = "填数字")
                                                                                @Positive
                                                                                @RequestParam
                                                                                        Integer current,
                                                                                @Digits(integer = 4, fraction = 0,
                                                                                        message = "填数字")
                                                                                @Positive
                                                                                @RequestParam
                                                                                        Integer size) {
        Page<StudentInfo> page = new Page<>(current, size, false);
        Page<StudentInfo> studentInfoPage = studentInfoService.page(page);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", studentInfoPage));
    }

    @GetMapping(value = "/fuzzy/{value}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<List<StudentInfo>>> getStudentInfoByFuzzyId(@NotBlank
                                                                                     @PathVariable
                                                                                             String value) {

        List<StudentInfo> studentInfoList =
                studentInfoService.list(new QueryWrapper<StudentInfo>().like(StudentInfo.COL_ID, value).or().like(StudentInfo.COL_NAME, value));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", studentInfoList));
    }
}
