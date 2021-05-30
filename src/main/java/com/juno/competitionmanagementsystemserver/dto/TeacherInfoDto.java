package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-TeacherInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 教师工号，作为登录账号
     */
    @Digits(integer = 15, fraction = 0)
    @Size(min = 8, max = 10)
    @Positive
    @ApiModelProperty(value = "教师工号，作为登录账号")
    private Integer id;
    /**
     * 教师姓名
     */
    @NotBlank
    @ApiModelProperty(value = "教师姓名")
    private String name;
    /**
     * 手机号码
     */
    @Digits(integer = 15, fraction = 0)
    @Size(min = 11, max = 15)
    @Positive
    @ApiModelProperty(value = "手机号码")
    private Integer telephone;
    /**
     * 邮箱
     */
    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 性别
     */
    @NotBlank
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 职位（讲师，副教授，教授）
     */
    @NotBlank
    @ApiModelProperty(value = "职位（讲师，副教授，教授）")
    private String position;
}
