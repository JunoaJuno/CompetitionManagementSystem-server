package com.juno.competitionmanagementsystemserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-CompetitionInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.competition_info")
public class CompetitionInfo implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_COMM_ID = "comm_id";
    public static final String COL_SIGNUP_START = "signup_start";
    public static final String COL_SIGNUP_END = "signup_end";
    public static final String COL_WORKS_END = "works_end";
    public static final String COL_LOCATION = "location";
    public static final String COL_SPONSOR = "sponsor";
    public static final String COL_UNDERTAKER = "undertaker";
    public static final String COL_STATE = "state";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_TIME = "update_time";
    public static final String COL_LEVEL = "level";
    public static final String COL_ORDER = "order";
    public static final String COL_TEAM_NUMBER = "team_number";
    public static final String COL_IS_PERSONAL_COMPETITION = "is_personal_competition";
    private static final long serialVersionUID = 1L;
    /**
     * 竞赛id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "竞赛id")
    private Integer id;
    /**
     * 竞赛名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "竞赛名称")
    private String name;
    /**
     * 竞赛主表ID
     */
    @TableField(value = "comm_id")
    @ApiModelProperty(value = "竞赛主表ID")
    private Integer commId;
    /**
     * 竞赛报名开始时间
     */
    @TableField(value = "signup_start")
    @ApiModelProperty(value = "竞赛报名开始时间")
    private Date signupStart;
    /**
     * 竞赛报名截止时间
     */
    @TableField(value = "signup_end")
    @ApiModelProperty(value = "竞赛报名截止时间")
    private Date signupEnd;
    /**
     * 竞赛作品提交截止时间
     */
    @TableField(value = "works_end")
    @ApiModelProperty(value = "竞赛作品提交截止时间")
    private Date worksEnd;
    /**
     * 竞赛地点
     */
    @TableField(value = "`location`")
    @ApiModelProperty(value = "竞赛地点")
    private String location;
    /**
     * 竞赛主办方
     */
    @TableField(value = "sponsor")
    @ApiModelProperty(value = "竞赛主办方")
    private String sponsor;
    /**
     * 竞赛承办方
     */
    @TableField(value = "undertaker")
    @ApiModelProperty(value = "竞赛承办方")
    private String undertaker;
    /**
     * 竞赛状态
     */
    @TableField(value = "`state`")
    @ApiModelProperty(value = "竞赛状态")
    private String state;
    /**
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "描述")
    private String description;
    /**
     * 竞赛信息创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "竞赛信息创建时间")
    private Date createTime;
    /**
     * 竞赛信息更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "竞赛信息更新时间")
    private Date updateTime;
    /**
     * 比赛级别：1:院赛 2:校赛 3:市赛 4:省赛 5:区域赛 6:国赛 7:全球
     */
    @TableField(value = "`level`")
    @ApiModelProperty(value = "比赛级别：1:院赛 2:校赛 3:市赛 4:省赛 5:区域赛 6:国赛 7:全球")
    private Byte level;
    /**
     * 比赛顺序
     */
    @TableField(value = "`order`")
    @ApiModelProperty(value = "比赛顺序")
    private Integer order;
    /**
     * 队伍人数
     */
    @TableField(value = "team_number")
    @ApiModelProperty(value = "队伍人数")
    private Integer teamNumber;
    /**
     * 是否个人比赛： 0不是，1是
     */
    @TableField(value = "is_personal_competition")
    @ApiModelProperty(value = "是否个人比赛： 0不是，1是")
    private Boolean isPersonalCompetition;
}