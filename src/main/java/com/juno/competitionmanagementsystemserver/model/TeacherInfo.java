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

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-TeacherInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.teacher_info")
public class TeacherInfo implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_TELEPHONE = "telephone";
    public static final String COL_EMAIL = "email";
    public static final String COL_SEX = "sex";
    public static final String COL_POSITION = "position";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_TIME = "update_time";
    private static final long serialVersionUID = 1L;
    /**
     * 教师工号，作为登录账号
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "教师工号，作为登录账号")
    private Integer id;
    /**
     * 教师姓名
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "教师姓名")
    private String name;
    /**
     * 手机号码
     */
    @TableField(value = "telephone")
    @ApiModelProperty(value = "手机号码")
    private Integer telephone;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 性别
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 职位（讲师，副教授，教授）
     */
    @TableField(value = "`position`")
    @ApiModelProperty(value = "职位（讲师，副教授，教授）")
    private String position;
    /**
     * 教师信息创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "教师信息创建时间")
    private Date createTime;
    /**
     * 教师信息更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "教师信息更新时间")
    private Date updateTime;
}