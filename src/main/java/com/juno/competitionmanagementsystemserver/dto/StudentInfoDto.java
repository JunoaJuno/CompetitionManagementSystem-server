package com.juno.competitionmanagementsystemserver.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com-juno-competitionmanagementsystemserver-model-StudentInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoDto implements Serializable {

    /**
     * 学生姓名
     */
    @ApiModelProperty(value="学生姓名")
    private String name;

    /**
     * 学生性别
     */
    @ApiModelProperty(value="学生性别")
    private String sex;

    /**
     * 学生所在班级号
     */
    @ApiModelProperty(value="学生所在班级号")
    private Integer classId;

    /**
     * 学生所属院系
     */
    @ApiModelProperty(value="学生所属院系")
    private String faculty;

    /**
     * 学生所属专业
     */
    @ApiModelProperty(value="学生所属专业")
    private String major;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private Integer telephone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String email;

    private static final long serialVersionUID = 1L;
}
