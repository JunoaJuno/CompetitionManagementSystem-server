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

@ApiModel(value="com-juno-competitionmanagementsystemserver-model-CompetitionResult")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.competition_result")
public class CompetitionResult implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * 竞赛ID
     */
    @TableField(value = "com_id")
    @ApiModelProperty(value="竞赛ID")
    private Integer comId;

    /**
     * 比赛队伍ID
     */
    @TableField(value = "team_id")
    @ApiModelProperty(value="比赛队伍ID")
    private Integer teamId;

    /**
     * 获奖等级（优胜，三等，二等，一等）
     */
    @TableField(value = "award_level")
    @ApiModelProperty(value="获奖等级（优胜，三等，二等，一等）")
    private String awardLevel;

    /**
     * 获奖日期
     */
    @TableField(value = "result_time")
    @ApiModelProperty(value="获奖日期")
    private Date resultTime;

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
     * 获奖队伍顺序
     */
    @TableField(value = "`order`")
    @ApiModelProperty(value="获奖队伍顺序")
    private Byte order;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_COM_ID = "com_id";

    public static final String COL_TEAM_ID = "team_id";

    public static final String COL_AWARD_LEVEL = "award_level";

    public static final String COL_RESULT_TIME = "result_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_ORDER = "order";
}