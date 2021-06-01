package com.juno.competitionmanagementsystemserver.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-juno-competitionmanagementsystemserver-dto-PhoneDto")
public class PhoneDto {

    @NotBlank
    private String encryptedData;

    @NotBlank
    private String iv;
}
