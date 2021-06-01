package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-juno-competitionmanagementsystemserver-dto-UserInfoDto")
public class UserInfoDto implements Serializable {

    @NotNull
    @ApiModelProperty(value = "头像")
    private String avatarUrl;

    @NotNull
    @ApiModelProperty(value = "城市")
    private String city;

    @NotNull
    @ApiModelProperty(value = "国家")
    private String country;

    @NotNull
    @ApiModelProperty(value = "性别：1男，0女")
    private Integer gender;

    @NotNull
    @ApiModelProperty(value = "语言")
    private String language;

    @NotNull
    @ApiModelProperty(value = "昵称")
    private String nickName;

    @NotNull
    @ApiModelProperty(value = "省份")
    private String province;

    private static final long serialVersionUID = 1L;
}
