package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ApiModel(value = "com-juno-competitionmanagementsystemserver-dto-DepartmentDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 部门名字
     */
    @ApiModelProperty(value = "部门名字")
    private String name;
    /**
     * 部门成员人数
     */
    @ApiModelProperty(value = "部门成员人数")
    private Integer number;
}
