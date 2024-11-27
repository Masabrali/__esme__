package com.esme.calender.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.esme.calender.dto.ProgressDTO;
import com.esme.calender.dto.TaskDTO;
import com.esme.calender.service.CalenderServices;

// @RequiredArgsConstructor
@RestController
public class CalenderController {

    @Autowired CalenderServices calenderServices;

    @GetMapping("/tasks")
    public Map<String, Object> getAllTasks() {
        return calenderServices.getAllTasks();
    }

    @GetMapping("/task/:taskUid")
    public Map<String, Object> getTaskById(String taskUid) {
        return calenderServices.getTaskById(taskUid);
    }

    @PostMapping("/task")
    public Map<String, Object> createOrUpdateTask(@RequestBody TaskDTO taskDTO, @RequestHeader("token") String token) {
        return calenderServices.createOrUpdateTask(taskDTO, token);
    }

    @DeleteMapping("/task/:taskUid")
    public Map<String, Object> deleteTask(String taskUid, @RequestHeader("token") String token) {
        return calenderServices.deleteTask(taskUid, token);
    }

    @GetMapping("/task/:taskUid/progress")
    public Map<String, Object> getProgressByTaskUid(String taskUid) {
        return calenderServices.getProgressByTaskUid(taskUid);
    }

    @PostMapping("/progress")
    public Map<String, Object> createOrUpdateProgress(@RequestBody ProgressDTO progressDTO, @RequestHeader("token") String token) {
        return calenderServices.createOrUpdateProgress(progressDTO, token);
    }

    @DeleteMapping("/progress/:progressUid")
    public Map<String, Object> deleteProgress(String progressUid, @RequestHeader("token") String token) {
        return calenderServices.deleteProgress(progressUid, token);
    }

}
