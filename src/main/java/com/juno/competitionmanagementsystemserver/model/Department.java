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

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-Department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.department")
public class Department implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_NUMBER = "number";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_TIME = "update_time";
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 部门名字
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "部门名字")
    private String name;
    /**
     * 部门成员人数
     */
    @TableField(value = "`number`")
    @ApiModelProperty(value = "部门成员人数")
    private Integer number;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}