package com.esme.calender.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esme.calender.dto.ProgressDTO;
import com.esme.calender.dto.TaskDTO;
import com.esme.calender.entity.Progress;
import com.esme.calender.entity.Task;
import com.esme.calender.repository.ProgressRepository;
import com.esme.calender.repository.TaskRepository;

@Service
public class CalenderServices {

    @Autowired TaskRepository taskRepository;
    @Autowired ProgressRepository progressRepository;

    private Map<String, Object> mp = null;

    public Map<String, Object> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        if(tasks.isEmpty()){
            mp.put("status", 0);
        } else{
            mp.put("status", 1);
            mp.put("result", tasks);
        } 
        return mp;
    }

    public Map<String, Object> getTaskById(String taskUid) {
        Optional<Task> task = taskRepository.findById(taskUid);
        if(task.isPresent()){
            mp.put("status", 1);
            mp.put("result", task);
        }else{
            mp.put("status", 0);
        }
        return mp;
    }

    public Map<String, Object> createOrUpdateTask(TaskDTO taskDTO, String token) {
        //TODO: Get username and userUid from token

        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
        Task savedTask = taskRepository.save(task);

        if(savedTask != null){
            mp.put("status", 1);
            mp.put("result", savedTask);
        }else{
            mp.put("status", 0);
        }
        return mp;
    }

    public Map<String, Object> deleteTask(String taskUid, String token) {
        //TODO: Get username and userUid from token
        String userUid = null;
        try {
            Task task = taskRepository.findByIdAndUserUid(taskUid, userUid);
            if(task==null){
                mp.put("status", 0);
                mp.put("message", "Task not found, or this task does not belong to you");
                return mp;
            }
            taskRepository.deleteByTaskUid(taskUid);
            mp.put("status", 1);
        } catch (Exception e) {
            mp.put("status", 0);
            mp.put("message", e.getMessage());
        }
        return mp;
    }


    public Map<String, Object> getProgressByTaskUid(String taskUid) {
        List<Progress> progress = progressRepository.findByTaskUid(taskUid);
        if(!progress.isEmpty()){
            mp.put("status", 1);
            mp.put("result", progress);
        }else{
            mp.put("status", 0);
        }
        return mp;
    }

    public Map<String, Object> createOrUpdateProgress(ProgressDTO progressDTO, String token) {
        //TODO: Get username and userUid from token
        try {
            Progress progress = new Progress();
            BeanUtils.copyProperties(progressDTO, progress);
            Progress savedProgress = progressRepository.save(progress);
            mp.put("status", 1);
            mp.put("result", savedProgress);
        } catch (Exception e) {
            mp.put("status", 0);
            mp.put("message", e.getMessage());
        }
        
        return null;
    }

    public Map<String, Object> deleteProgress(String progressUid, String token) {
        //TODO: Get username and userUid from token
        String userUid = null;

        try {
            Optional<Progress> progress = progressRepository.findById(progressUid);
            if(!progress.isPresent()){
                mp.put("status", 0);
                mp.put("message", "Progress not found");
                return mp;
            }
            Optional<Task> task = taskRepository.findById(progress.get().getTask().getId());
            if(!task.isPresent()){
                mp.put("status", 0);
                mp.put("message", "Task not found");
                return mp;
            }

            if(task.get().getUserUid().equalsIgnoreCase(userUid)){

                progressRepository.deleteByProgressId(progressUid);
                mp.put("status", 1);
            }else{
                mp.put("status", 0);
                mp.put("message", "You are not authorized to delete this progress");
            }
    
        } catch (Exception e) {
            mp.put("status", 0);
            mp.put("message", e.getMessage());
        }

        return mp;
    }

}
