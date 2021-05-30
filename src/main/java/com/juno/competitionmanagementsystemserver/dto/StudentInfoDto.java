package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-StudentInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 学生的学号，作为账号登录
     */
    @Digits(integer = 15, fraction = 0)
    @Size(min = 8, max = 10)
    @Positive
    @ApiModelProperty(value = "学生的学号，作为账号登录")
    private Integer id;
    /**
     * 学生姓名
     */
    @NotBlank
    @ApiModelProperty(value = "学生姓名")
    private String name;
    /**
     * 学生性别
     */
    @NotBlank
    @ApiModelProperty(value = "学生性别")
    private String sex;
    /**
     * 学生所在班级号
     */
    @Digits(integer = 20, fraction = 0)
    @Size(min = 8, max = 10)
    @Positive
    @ApiModelProperty(value = "学生所在班级号")
    private Integer classId;
    /**
     * 学生所属院系
     */
    @NotBlank
    @ApiModelProperty(value = "学生所属院系")
    private String faculty;
    /**
     * 学生所属专业
     */
    @NotBlank
    @ApiModelProperty(value = "学生所属专业")
    private String major;
    /**
     * 手机号
     */
    @Digits(integer = 15, fraction = 0)
    @Size(min = 11, max = 15)
    @Positive
    @ApiModelProperty(value = "手机号")
    private Integer telephone;
    /**
     * 邮箱
     */
    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;
}
