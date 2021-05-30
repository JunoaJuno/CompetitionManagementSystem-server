package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ApiModel(value = "com-juno-competitionmanagementsystemserver-dto-CompetitionTeamDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionTeamDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 队伍名字
     */
    @ApiModelProperty(value = "队伍名字")
    private String name;
    /**
     * 队伍备注
     */
    @ApiModelProperty(value = "队伍备注")
    private String comment;
    /**
     * 比赛ID
     */
    @ApiModelProperty(value = "比赛ID")
    private Integer competitionId;
    /**
     * 比赛赛道id
     */
    @ApiModelProperty(value = "比赛赛道id")
    private Byte raceTrackId;
    /**
     * 作品ID
     */
    @ApiModelProperty(value = "作品ID")
    private Integer workId;
}
