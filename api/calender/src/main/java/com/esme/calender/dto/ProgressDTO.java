package com.esme.calender.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ProgressDTO {

    private String id;

    private String taskUid;

    private String description;
    
    private Date date;
}
