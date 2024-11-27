package com.esme.calender.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class TaskDTO {

    private String id;
    
    private String name;

    private Date starDate;

    private int duration;
}
