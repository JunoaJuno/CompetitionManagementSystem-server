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

@ApiModel(value="com-juno-competitionmanagementsystemserver-dto-DepartmentDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto implements Serializable {

    /**
     * 部门名字
     */
    @ApiModelProperty(value="部门名字")
    private String name;

    /**
     * 部门成员人数
     */
    @ApiModelProperty(value="部门成员人数")
    private Integer number;


    private static final long serialVersionUID = 1L;
}
