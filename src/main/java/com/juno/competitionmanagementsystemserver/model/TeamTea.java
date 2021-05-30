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

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-TeamTea")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.team_tea")
public class TeamTea implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_TEAM_ID = "team_id";
    public static final String COL_TEA_ID = "tea_id";
    public static final String COL_ORDER = "order";
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 比赛ID
     */
    @TableField(value = "team_id")
    @ApiModelProperty(value = "比赛ID")
    private Integer teamId;
    /**
     * 老师ID
     */
    @TableField(value = "tea_id")
    @ApiModelProperty(value = "老师ID")
    private Integer teaId;
    /**
     * 教师顺序
     */
    @TableField(value = "`order`")
    @ApiModelProperty(value = "教师顺序")
    private Byte order;
}