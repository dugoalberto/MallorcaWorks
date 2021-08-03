package com.mallorcaWorks.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CourseForm {

    @NotBlank
    private String level;

    @NotNull
    private Date beginDate;

    @NotNull
    private Date endDate;
    
    @NotBlank
    private String teacher;
    
}
