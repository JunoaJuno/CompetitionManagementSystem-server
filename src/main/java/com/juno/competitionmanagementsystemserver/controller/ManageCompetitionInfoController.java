package com.juno.competitionmanagementsystemserver.controller;


import com.juno.competitionmanagementsystemserver.dto.CompetitionSlaveDto;
import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import com.juno.competitionmanagementsystemserver.model.CompetitionInfo;
import com.juno.competitionmanagementsystemserver.service.CompetitionInfoService;
import com.juno.competitionmanagementsystemserver.service.CompetitionMasterInfoService;
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

@Api(tags = "管理子比赛")
@Controller
@CrossOrigin
@RequestMapping(value = {"/api/v1/manage/competition/slave"})
public class ManageCompetitionInfoController {

    private final CompetitionInfoService competitionInfoService;
    private final CompetitionMasterInfoService competitionMasterInfoService;

    public ManageCompetitionInfoController(CompetitionInfoService competitionInfoService,
                                           CompetitionMasterInfoService competitionMasterInfoService) {
        this.competitionMasterInfoService = competitionMasterInfoService;
        this.competitionInfoService = competitionInfoService;
    }

    @PutMapping(value = "{masterId}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> addSlaveCompetition(@Digits(integer = 10, fraction = 0)
                                                                      @Positive
                                                                      @PathVariable
                                                                              Integer masterId,
                                                                      @NotEmpty
                                                                      @Size(min = 1)
                                                                      @RequestBody
                                                                              List<CompetitionSlaveDto> competitionSlaveDtoList) {
        if (competitionMasterInfoService.has(masterId)) {
            if (competitionInfoService.saveBatch(masterId, competitionSlaveDtoList)) {
                return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStruct<>("ok", ""));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseStruct<>("master id 不存在", ""));
        }
    }

    @GetMapping(value = "/getByMaster/{masterId}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<List<CompetitionInfo>>> getByMasterId(@Digits(integer = 10, fraction = 0)
                                                                               @Positive
                                                                               @PathVariable
                                                                                       Integer masterId
    ) {
        List<CompetitionInfo> competitionInfoList = competitionInfoService.getByMasterId(masterId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", competitionInfoList));
    }

    @GetMapping(value = "/getBySlave/{slaveId}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<CompetitionInfo>> getBySlaveId(@Digits(integer = 10, fraction = 0)
                                                                        @Positive
                                                                        @PathVariable
                                                                                Integer slaveId) {
        CompetitionInfo competitionInfo = competitionInfoService.getById(slaveId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", competitionInfo));
    }

    @PostMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> changeCompetitionInfo(@Digits(integer = 10, fraction = 0)
                                                                        @Positive
                                                                        @PathVariable
                                                                                Integer id,
                                                                        @RequestBody
                                                                                CompetitionSlaveDto competitionSlaveDto) {
        if (competitionInfoService.updateById(id, competitionSlaveDto)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> deleteById(@Digits(integer = 10, fraction = 0)
                                                             @Positive
                                                             @PathVariable
                                                                     Integer id) {
        if (competitionInfoService.removeById(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStruct<>("ok", ""));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", ""));
        }
    }
}

