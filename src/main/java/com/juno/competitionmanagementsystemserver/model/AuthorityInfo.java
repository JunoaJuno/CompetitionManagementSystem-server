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

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-AuthorityInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.authority_info")
public class AuthorityInfo implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_TYPE = "type";
    public static final String COL_ACTION = "action";
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Integer id;
    /**
     * 权限名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "权限名称")
    private String name;
    /**
     * 接口权限地址
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value = "接口权限地址")
    private String type;
    /**
     * 权限动作（GET、POST、PUT、DELETE）
     */
    @TableField(value = "`action`")
    @ApiModelProperty(value = "权限动作（GET、POST、PUT、DELETE）")
    private String action;
}