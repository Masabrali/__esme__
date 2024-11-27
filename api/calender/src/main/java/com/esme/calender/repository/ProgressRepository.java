package com.esme.calender.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esme.calender.entity.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, String>{

  @Query("SELECT p FROM Progress p WHERE p.task.id = :taskUid")
    List<Progress> findByTaskUid(@Param("taskUid") String taskUid);

    @Modifying
    @Query("DELETE FROM Progress p WHERE p.id = :progressUid")
    void deleteByProgressId(@Param("progressUid") String progressUid);
}
