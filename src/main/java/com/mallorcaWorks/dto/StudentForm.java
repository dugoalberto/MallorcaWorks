package com.mallorcaWorks.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StudentForm {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String languageLevel;

    @NotBlank
    private int weeks;

    @NotNull
    private String image;

    @NotNull
    private String nationality;

    @NotBlank
    private Date dateOfBirth;

    @NotBlank
    private String course;

}
