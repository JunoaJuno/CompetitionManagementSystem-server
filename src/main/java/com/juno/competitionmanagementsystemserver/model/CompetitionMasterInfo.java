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

/**
    * 竞赛主表
    */
@ApiModel(value="com-juno-competitionmanagementsystemserver-model-CompetitionMasterInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.competition_master_info")
public class CompetitionMasterInfo implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="ID")
    private Integer id;

    /**
     * 竞赛名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="竞赛名称")
    private String name;

    /**
     * 竞赛年份（供查询）
     */
    @TableField(value = "`year`")
    @ApiModelProperty(value="竞赛年份（供查询）")
    private Object year;

    /**
     * 竞赛种类说明
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value="竞赛种类说明")
    private String type;

    /**
     * 其他说明
     */
    @TableField(value = "description")
    @ApiModelProperty(value="其他说明")
    private String description;

    /**
     * 竞赛信息创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="竞赛信息创建时间")
    private Date createTime;

    /**
     * 竞赛信息更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="竞赛信息更新时间")
    private Date updateTime;

    /**
     * 比赛赛道
     */
    @TableField(value = "race_track")
    @ApiModelProperty(value="比赛赛道")
    private String raceTrack;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_YEAR = "year";

    public static final String COL_TYPE = "type";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_RACE_TRACK = "race_track";
}