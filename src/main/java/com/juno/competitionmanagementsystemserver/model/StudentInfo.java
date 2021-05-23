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

@ApiModel(value="com-juno-competitionmanagementsystemserver-model-StudentInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.student_info")
public class StudentInfo implements Serializable {
    /**
     * 学生的学号，作为账号登录
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="学生的学号，作为账号登录")
    private Integer id;

    /**
     * 学生姓名
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="学生姓名")
    private String name;

    /**
     * 学生性别
     */
    @TableField(value = "sex")
    @ApiModelProperty(value="学生性别")
    private String sex;

    /**
     * 学生所在班级号
     */
    @TableField(value = "class_id")
    @ApiModelProperty(value="学生所在班级号")
    private Integer classId;

    /**
     * 学生所属院系
     */
    @TableField(value = "faculty")
    @ApiModelProperty(value="学生所属院系")
    private String faculty;

    /**
     * 学生所属专业
     */
    @TableField(value = "major")
    @ApiModelProperty(value="学生所属专业")
    private String major;

    /**
     * 手机号
     */
    @TableField(value = "telephone")
    @ApiModelProperty(value="手机号")
    private Integer telephone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 学生信息创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="学生信息创建时间")
    private Date createTime;

    /**
     * 学生信息更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="学生信息更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_SEX = "sex";

    public static final String COL_CLASS_ID = "class_id";

    public static final String COL_FACULTY = "faculty";

    public static final String COL_MAJOR = "major";

    public static final String COL_TELEPHONE = "telephone";

    public static final String COL_EMAIL = "email";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}