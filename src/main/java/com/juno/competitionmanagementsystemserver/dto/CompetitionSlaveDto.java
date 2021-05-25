package com.juno.competitionmanagementsystemserver.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com-juno-competitionmanagementsystemserver-dto-CompetitionSlaveDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionSlaveDto implements Serializable {

    /**
     * 竞赛名称
     */
    @NotBlank
    @Size(min = 3, max = 30)
    @ApiModelProperty(value="竞赛名称")
    private String name;

    /**
     * 竞赛报名开始时间
     */
    @PastOrPresent
    @ApiModelProperty(value="竞赛报名开始时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date signupStart;

    /**
     * 竞赛报名截止时间
     */
    @PastOrPresent
    @ApiModelProperty(value="竞赛报名截止时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date signupEnd;

    /**
     * 竞赛作品提交截止时间
     */
    @PastOrPresent
    @ApiModelProperty(value="竞赛作品提交截止时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date worksEnd;

    /**
     * 竞赛地点
     */
    @NotBlank
    @ApiModelProperty(value="竞赛地点")
    private String location;

    /**
     * 竞赛主办方
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value="竞赛主办方")
    private String sponsor;

    /**
     * 竞赛承办方
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value="竞赛承办方")
    private String undertaker;

    /**
     * 竞赛状态
     */
    @NotBlank
    @ApiModelProperty(value="竞赛状态")
    private String state;

    /**
     * 描述
     */
    @NotNull
    @ApiModelProperty(value="描述")
    private String description;

    /**
     * 比赛级别：1:院赛 2:校赛 3:市赛 4:省赛 5:区域赛 6:国赛 7:全球
     */
    @Positive
    @Digits( integer = 1, fraction = 0)
    @ApiModelProperty(value="比赛级别：1:院赛 2:校赛 3:市赛 4:省赛 5:区域赛 6:国赛 7:全球")
    private Byte level;


    private static final long serialVersionUID = 1L;
}
