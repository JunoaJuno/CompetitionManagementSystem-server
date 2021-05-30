package com.juno.competitionmanagementsystemserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import com.juno.competitionmanagementsystemserver.dto.TeacherInfoDto;
import com.juno.competitionmanagementsystemserver.model.TeacherInfo;
import com.juno.competitionmanagementsystemserver.service.TeacherInfoService;
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

@Api(tags = "教师信息")
@Controller
@CrossOrigin
@RequestMapping(value = {"/api/v1/teacher/info"})
public class TeacherInfoController {

    private final TeacherInfoService teacherInfoService;

    public TeacherInfoController(TeacherInfoService teacherInfoService) {
        this.teacherInfoService = teacherInfoService;
    }

    @PutMapping()
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> addTeacherInfo(@RequestBody TeacherInfoDto teacherInfoDto) {
        if (teacherInfoService.save(teacherInfoDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @PostMapping()
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> changeTeacherInfo(@RequestBody TeacherInfoDto teacherInfoDto) {
        if (teacherInfoService.updateById(teacherInfoDto)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> deleteTeacherInfo(@Digits(integer = 10, fraction = 0)
                                                                    @Positive
                                                                    @PathVariable
                                                                            Integer id) {
        if (teacherInfoService.removeById(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<TeacherInfo>> getTeacherInfo(@Digits(integer = 10, fraction = 0)
                                                                      @Positive
                                                                      @PathVariable
                                                                              Integer id) {
        TeacherInfo teacherInfo = teacherInfoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", teacherInfo));
    }

    @GetMapping(value = "/list")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<Page<TeacherInfo>>> getTeacherInfoList(@Digits(integer = 4, fraction = 0,
            message = "填数字")
                                                                                @Positive
                                                                                @RequestParam
                                                                                        Integer current,
                                                                                @Digits(integer = 4, fraction = 0,
                                                                                        message = "填数字")
                                                                                @Positive
                                                                                @RequestParam
                                                                                        Integer size) {
        Page<TeacherInfo> page = new Page<>(current, size, false);
        Page<TeacherInfo> teacherInfoPage = teacherInfoService.page(page);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", teacherInfoPage));
    }

    @GetMapping(value = "/fuzzy/{value}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<List<TeacherInfo>>> getStudentInfoByFuzzyId(@NotBlank
                                                                                     @PathVariable
                                                                                             String value) {
        List<TeacherInfo> teacherInfoList =
                teacherInfoService.list(new QueryWrapper<TeacherInfo>().like(TeacherInfo.COL_ID, value).or().like(TeacherInfo.COL_NAME, value));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", teacherInfoList));
    }
}
