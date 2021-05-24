package com.juno.competitionmanagementsystemserver.dto;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="com-juno-competitionmanagementsystemserver-dto-CompetitionMasterDto")
public class CompetitionMasterDto implements Serializable {

    /**
     * 竞赛名称
     */
    @NotBlank(message = "参赛名称不能为空")
    @Size(min = 1, max = 40, message = "参赛名称长度必须在1-40之间")
    @ApiModelProperty(value="竞赛名称")
    private String name;

    /**
     * 竞赛年份（供查询）
     */
    @Digits(integer = 4, fraction = 0, message = "填入年份数字")
    @ApiModelProperty(value="竞赛年份（供查询）")
    private Integer year;

    /**
     * 竞赛种类说明
     */
    @NotBlank(message = "竞赛种类不能为空")
    @ApiModelProperty(value="竞赛种类说明")
    private String type;

    /**
     * 其他说明
     */
    @NotNull(message = "description 不能为空")
    @ApiModelProperty(value="其他说明")
    private String description;


    /**
     * 比赛赛道
     */
    @NotNull(message = "比赛赛道不能为空")
    @ApiModelProperty(value="比赛赛道")
    private List<String> raceTrack;


    public String getRaceTrack(){
        return JSON.toJSON(this.raceTrack).toString();
    }

    private static final long serialVersionUID = 1L;
}
