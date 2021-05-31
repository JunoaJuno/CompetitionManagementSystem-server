package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-juno-competitionmanagementsystemserver-dto-ArticleListDto")
public class ArticleListDto implements Serializable {

    private List<ArticleDto> articleDtoList;

    private static final long serialVersionUID = 1L;
}
