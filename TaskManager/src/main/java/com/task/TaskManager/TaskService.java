package com.task.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	TaskManagerRepo taskRepo;
	
	//This Method Iterates through the Entity Class and Gets all the Tasks
	public Iterable<TaskManagerEntity> GetAllTasks() {
		return taskRepo.findAll();
	}
}
