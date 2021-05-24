package com.juno.competitionmanagementsystemserver.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Tokens implements Serializable {

    private Integer id;

    private Date createdAt;

    private Date updatedAt;

    private Integer userId;
}
