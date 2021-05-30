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

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-TeamStu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.team_stu")
public class TeamStu implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_TEAM_ID = "team_id";
    public static final String COL_STU_ID = "stu_id";
    public static final String COL_ORDER = "order";
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 队伍ID
     */
    @TableField(value = "team_id")
    @ApiModelProperty(value = "队伍ID")
    private Integer teamId;
    /**
     * 学生ID
     */
    @TableField(value = "stu_id")
    @ApiModelProperty(value = "学生ID")
    private Integer stuId;
    /**
     * 学生顺序：1表示队长
     */
    @TableField(value = "`order`")
    @ApiModelProperty(value = "学生顺序：1表示队长")
    private Byte order;
}