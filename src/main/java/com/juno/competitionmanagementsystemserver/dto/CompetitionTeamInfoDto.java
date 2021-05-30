package com.juno.competitionmanagementsystemserver.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.juno.competitionmanagementsystemserver.model.StudentInfo;
import com.juno.competitionmanagementsystemserver.model.TeacherInfo;
import com.juno.competitionmanagementsystemserver.model.WorkInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@ApiModel(value = "com-juno-competitionmanagementsystemserver-Dto-CompetitionTeamInfoDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionTeamInfoDto {
    /**
     * team id
     */
    @ApiModelProperty(value = "team id")
    private Integer id;
    /**
     * 队伍名字
     */
    @ApiModelProperty(value = "队伍名字")
    private String name;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 队伍备注
     */
    @ApiModelProperty(value = "队伍备注")
    private String comment;
    /**
     * 比赛ID
     */
    @ApiModelProperty(value = "比赛ID")
    private Integer competitionId;
    /**
     * 报名是否成功:0 失败，1 成功， 2审核中
     */
    @ApiModelProperty(value = "报名是否成功:0 失败，1 成功， 2审核中")
    private Byte isRegistrationReviewPass;
    /**
     * 比赛赛道id
     */
    @ApiModelProperty(value = "比赛赛道id")
    private Byte raceTrackId;
    /**
     * 作品
     */
    @ApiModelProperty(value = "作品")
    private WorkInfo workInfo;

    @ApiModelProperty(value = "队伍学生")
    private List<StudentInfo> studentInfoList;

    @ApiModelProperty(value = "指导老师")
    private List<TeacherInfo> teacherInfoList;
}
