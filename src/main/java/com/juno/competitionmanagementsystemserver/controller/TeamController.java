package com.juno.competitionmanagementsystemserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juno.competitionmanagementsystemserver.dto.CompetitionTeamDto;
import com.juno.competitionmanagementsystemserver.dto.CompetitionTeamInfoDto;
import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import com.juno.competitionmanagementsystemserver.model.CompetitionInfo;
import com.juno.competitionmanagementsystemserver.model.CompetitionTeam;
import com.juno.competitionmanagementsystemserver.model.TeamStu;
import com.juno.competitionmanagementsystemserver.model.TeamTea;
import com.juno.competitionmanagementsystemserver.service.CompetitionInfoService;
import com.juno.competitionmanagementsystemserver.service.CompetitionTeamService;
import com.juno.competitionmanagementsystemserver.service.TeamStuService;
import com.juno.competitionmanagementsystemserver.service.TeamTeaService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.LinkedList;
import java.util.List;

@Api(tags = "队伍管理")
@Controller
@CrossOrigin
@RequestMapping(value = {"/api/v1/team"})
public class TeamController {

    private final CompetitionTeamService competitionTeamService;
    private final CompetitionInfoService competitionInfoService;
    private final TeamStuService teamStuService;
    private final TeamTeaService teamTeaService;

    public TeamController(CompetitionTeamService competitionTeamService, CompetitionInfoService competitionInfoService, TeamStuService teamStuService, TeamTeaService teamTeaService) {
        this.competitionTeamService = competitionTeamService;
        this.competitionInfoService = competitionInfoService;
        this.teamStuService = teamStuService;
        this.teamTeaService = teamTeaService;
    }

    @PutMapping(value = "{competitionId}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> addTeam(@RequestBody CompetitionTeamDto competitionTeamDto,
                                                          @NotEmpty
                                                                  List<Integer> studentIdList,
                                                          @NotEmpty
                                                          List<Integer> teacherIdList,
                                                          @Digits(integer = 10, fraction = 0)
                                                          @Positive
                                                          @RequestParam
                                                          Integer competitionId) {
        CompetitionInfo competitionInfo = competitionInfoService.getById(competitionTeamDto.getCompetitionId());
        Assert.isTrue(studentIdList.size() <= competitionInfo.getTeamNumber(), "参赛学生数量超过比赛限制");
        Assert.isTrue(teacherIdList.size() <= competitionInfo.getTeamNumber(), "指导教师数量超过比赛限制");
        CompetitionTeam competitionTeam = competitionTeamService.save(competitionTeamDto);
        Assert.notNull(competitionTeam, "创建失败");
        Assert.isTrue(teamStuService.saveBatch(competitionTeam.getId(), studentIdList), "创建失败");
        Assert.isTrue( teamTeaService.saveBatch(competitionTeam.getId(), teacherIdList), "创建失败");
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStruct<>("ok", ""));
    }

    @PostMapping(value = "{id}")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<String>> changeTeam(@RequestBody CompetitionTeamDto competitionTeamDto,
                                                             @NotEmpty
                                                                     List<Integer> studentIdList,
                                                             @NotEmpty
                                                                         List<Integer> teacherIdList,
                                                             @Digits(integer = 10, fraction = 0)
                                                             @Positive
                                                             @RequestParam
                                                             Integer id) {
        CompetitionInfo competitionInfo = competitionInfoService.getById(competitionTeamDto.getCompetitionId());
        Assert.isTrue(studentIdList.size() <= competitionInfo.getTeamNumber(), "参赛学生数量超过比赛限制");
        Assert.isTrue(teacherIdList.size() <= competitionInfo.getTeamNumber(), "指导教师数量超过比赛限制");
        CompetitionTeam competitionTeam = competitionTeamService.updateById(id, competitionTeamDto);
        Assert.notNull(competitionTeam, "更新失败");
        try {
            teamStuService.updateById(competitionTeam.getId(), studentIdList);
            teamTeaService.updateById(competitionTeam.getId(), teacherIdList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("failed", "更新失败"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStruct<>("ok", ""));
    }

//    @GetMapping( value = "/list/{competitionId}")
//    @ResponseBody
//    @Valid
//    public ResponseEntity<ResponseStruct<CompetitionTeamInfoDto>> getTeamInfo(@Digits(integer = 10, fraction = 0)
//                                                                                  @Positive
//                                                                                  @RequestParam
//                                                                                      Integer competitionId) {
//        List<CompetitionTeam> competitionTeamList =
//                competitionTeamService.list(new QueryWrapper<CompetitionTeam>().eq(CompetitionTeam.COL_COMPETITION_ID,
//                competitionId));
//        List<Integer> workIdList = new LinkedList<>();
//        List<Integer> teamIdList = new LinkedList<>();
//        for (CompetitionTeam competitionTeam : competitionTeamList) {
//            workIdList.add(competitionTeam.getWorkId());
//            teamIdList.add(competitionTeam.getId());
//        }
//        List<TeamStu> teamStuList = teamStuService.list(new QueryWrapper<TeamStu>().in(TeamStu.COL_TEAM_ID,
//                teamIdList));
//        List<TeamTea> teamTeaList = teamTeaService.list(new QueryWrapper<TeamTea>().in(TeamTea.COL_TEAM_ID,
//                teamIdList));
//
//    }

}
