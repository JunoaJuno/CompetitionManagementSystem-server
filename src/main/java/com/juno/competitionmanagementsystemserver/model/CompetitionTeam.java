package com.juno.competitionmanagementsystemserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-juno-competitionmanagementsystemserver-model-CompetitionTeam")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.competition_team")
public class CompetitionTeam implements Serializable {
    /**
     * team id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="team id")
    private Integer id;

    /**
     * 队伍名字
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="队伍名字")
    private String name;

    /**
     * 队伍人数
     */
    @TableField(value = "`number`")
    @ApiModelProperty(value="队伍人数")
    private Integer number;

    /**
     * 是否个人比赛： 0不是，1是
     */
    @TableField(value = "is_personal_competition")
    @ApiModelProperty(value="是否个人比赛： 0不是，1是")
    private Boolean isPersonalCompetition;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 队伍备注
     */
    @TableField(value = "`comment`")
    @ApiModelProperty(value="队伍备注")
    private String comment;

    /**
     * 比赛ID
     */
    @TableField(value = "competition_id")
    @ApiModelProperty(value="比赛ID")
    private Integer competitionId;

    /**
     * 报名是否成功:0 失败，1 成功， 2审核中
     */
    @TableField(value = "is_registration_review_pass")
    @ApiModelProperty(value="报名是否成功:0 失败，1 成功， 2审核中")
    private Byte isRegistrationReviewPass;

    /**
     * 比赛赛道id
     */
    @TableField(value = "race_track_id")
    @ApiModelProperty(value="比赛赛道id")
    private Byte raceTrackId;

    /**
     * 作品ID
     */
    @TableField(value = "work_id")
    @ApiModelProperty(value="作品ID")
    private Integer workId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_NUMBER = "number";

    public static final String COL_IS_PERSONAL_COMPETITION = "is_personal_competition";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_COMMENT = "comment";

    public static final String COL_COMPETITION_ID = "competition_id";

    public static final String COL_IS_REGISTRATION_REVIEW_PASS = "is_registration_review_pass";

    public static final String COL_RACE_TRACK_ID = "race_track_id";

    public static final String COL_WORK_ID = "work_id";
}