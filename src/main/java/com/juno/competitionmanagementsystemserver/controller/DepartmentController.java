package com.juno.competitionmanagementsystemserver.controller;

import com.juno.competitionmanagementsystemserver.dto.DepartmentDto;
import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import com.juno.competitionmanagementsystemserver.model.Department;
import com.juno.competitionmanagementsystemserver.service.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Api(tags = "管理部门")
@Controller
@CrossOrigin
@RequestMapping(value = {"/api/v1/department/"})
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<List<Department>>> getDepartmentList() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", departmentService.list()));
    }

    @PostMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> changeDepartment(@Digits(integer = 10, fraction = 0)
                                                                   @Positive
                                                                   @PathVariable
                                                                           Integer id,
                                                                   @RequestBody
                                                                           DepartmentDto departmentDto
                                                                    ) {
        if (departmentService.updateById(id, departmentDto)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @PutMapping()
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> addDepartment(@NotEmpty
                                                                @Size(min = 1)
                                                                @RequestBody
                                                                List<DepartmentDto> departmentDtoList) {
        if (departmentService.saveBatch(departmentDtoList)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> deleteDepartment(@Digits(integer = 10, fraction = 0)
                                                                   @Positive
                                                                   @PathVariable
                                                                           Integer id) {
        if (departmentService.removeById(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }
}
