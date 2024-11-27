package com.esme.calender.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Progress extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "task_uid", nullable = false, referencedColumnName = "id")
    private Task task;
    private String description;
    private Date date;

    public Task getTask() {
        return this.task;
    }

}
