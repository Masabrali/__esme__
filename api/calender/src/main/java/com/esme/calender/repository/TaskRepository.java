package com.esme.calender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esme.calender.entity.Task;

import jakarta.transaction.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Task t WHERE t.id = :taskUid")
    void deleteByTaskUid(@Param("taskUid") String taskUid);
    
    Task findByIdAndUserUid(String taskUid, String userUid);
}
