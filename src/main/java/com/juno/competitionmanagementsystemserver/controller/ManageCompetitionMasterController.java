package com.juno.competitionmanagementsystemserver.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juno.competitionmanagementsystemserver.dto.CompetitionMasterDto;
import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import com.juno.competitionmanagementsystemserver.model.CompetitionMasterInfo;
import com.juno.competitionmanagementsystemserver.service.CompetitionMasterInfoService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;

@Api(tags = "管理主比赛")
@Controller
@CrossOrigin
@RequestMapping(value = {"/api/v1/manage/competition/master"})
public class ManageCompetitionMasterController {

    private final CompetitionMasterInfoService competitionMasterInfoService;

    public ManageCompetitionMasterController(CompetitionMasterInfoService competitionMasterInfoService) {
        this.competitionMasterInfoService = competitionMasterInfoService;
    }

    //    @PreAuthorize("hasRole('ROLE_VIEWER')")
    @PutMapping()
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> addMasterCompetition(@RequestBody CompetitionMasterDto comMatDto) {
        if (competitionMasterInfoService.addNewCompMaster(comMatDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }

    }

    @GetMapping(value = "list")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<Page<CompetitionMasterInfo>>> getMasterCompetitionList(@Digits(integer = 4,
            fraction = 0, message = "填数字")
                                                                                                @Positive
                                                                                                @RequestParam
                                                                                                        Integer current,
                                                                                                @Digits(integer = 4,
                                                                                                        fraction = 0,
                                                                                                        message = "填数字")
                                                                                                @Positive
                                                                                                @RequestParam
                                                                                                        Integer size) {
        Page<CompetitionMasterInfo> page = new Page<>(current, size, false);
        Page<CompetitionMasterInfo> competitionMasterInfoList = competitionMasterInfoService.page(page);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", competitionMasterInfoList));
    }

    @PostMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> changeMasterCompetition(@Digits(integer = 10, fraction = 0,
            message = "必须为数字")
                                                                          @Positive
                                                                          @PathVariable Integer id,
                                                                          @RequestBody CompetitionMasterDto comMatDto) {
        if (competitionMasterInfoService.updateById(id, comMatDto)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> deleteMasterCompetition(@Digits(integer = 10, fraction = 0,
            message = "必须为数字")
                                                                          @Positive
                                                                          @PathVariable Integer id) {
        if (competitionMasterInfoService.removeById(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }
}
