package com.esme.calender.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task extends BaseEntity {

    private String name;

    private Date startDate;

    private int duration;

    private boolean completed;

    private String userName;

    private String userUid;

    public String getUserUid() {
        return this.userUid;
    }

}
