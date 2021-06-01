package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-juno-competitionmanagementsystemserver-dto-ArticlesDto")
public class ArticlesDto implements Serializable {

    private String title;

    private String author;

    private String digest;

    private String url;

    private String thumbUrl;

    private static final long serialVersionUID = 1L;
}
