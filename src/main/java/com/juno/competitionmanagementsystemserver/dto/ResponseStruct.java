package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-juno-competitionmanagementsystemserver-dto-CompetitionMasterDto")
public class ResponseStruct<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotBlank
    @ApiModelProperty(value = "返回信息")
    private String message;
    @NotBlank
    @ApiModelProperty(value = "返回数据")
    private T data;
}
