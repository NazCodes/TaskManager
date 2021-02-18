package com.task.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
@Controller
@SessionAttributes("taskName") //Need SessionAttributes to link the taskName
public class TaskManagerController {
	@Autowired
	TaskUserRepo userRepo;
	
	@Autowired
	TaskManagerRepo taskRepo;
	
	@Autowired
	TaskService taskService;
	
	//Create Task JSP's
	ModelAndView createTaskView = new ModelAndView("createtask");
	ModelAndView createTaskFailedView = new ModelAndView("createtaskfailed");
	ModelAndView displayTaskView = new ModelAndView("displaytask");
	
	//Update Task JSP's
	ModelAndView updateTaskView = new ModelAndView("updatetask");
	ModelAndView updateTaskPassedView = new ModelAndView("updatetaskpassed");
	ModelAndView updateTaskFailedView = new ModelAndView("updatetaskfailed");
	
	//Delete Task JSP's
	ModelAndView deleteTaskView = new ModelAndView("deletetask");
	ModelAndView deleteTaskPassedView = new ModelAndView("deletetaskpassed");
	ModelAndView deleteTaskFailedView = new ModelAndView("deletetaskfailed");
	
	//Register User JSP's
	ModelAndView registerView = new ModelAndView("register");
	ModelAndView registerPassedView = new ModelAndView("registerpassed");
	ModelAndView registerFailedView = new ModelAndView("registerfailed");
	
	//Login User JSP's
	ModelAndView loginView = new ModelAndView("login");
	ModelAndView loginPassedView = new ModelAndView("loginpassed");
	ModelAndView loginFailedView = new ModelAndView("loginfailed");
	
	//Start of Registration and Login Events-------------------------
	
	@GetMapping(path = "/registertaskuser")
	public ModelAndView registerUser() {
		return registerView;
	}
	
	@PostMapping(path = "/registertaskuserpassed")
	public ModelAndView registerPassed(@ModelAttribute TaskUserEntity userEntity) {
		userRepo.save(userEntity);
		if((userEntity.getUserEmail() != null && userEntity.getUserName() != null) && (userEntity.getPassword() != null)) {
			return registerPassedView;
		}
		return registerFailedView;
	}
	
	@GetMapping(path = "/logintaskuser")
	public ModelAndView loginUser() {
		return loginView;
	}
	
	@PostMapping(path = "/logintaskuserpassed")
	public ModelAndView loginPassed(@ModelAttribute TaskUserEntity userEntity) {
		Iterable<TaskUserEntity> userData = userRepo.findAll();
		for(TaskUserEntity myEntity : userData) {
			if(myEntity.getUserName().equals(userEntity.getUserName()) && myEntity.getPassword().equals(userEntity.getPassword())) {
				return createTaskView;
			}
		}
		return loginFailedView;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------//
	//Start of Task Events
	
	@GetMapping(path = "/createtask")
	public ModelAndView createTask() {
		return createTaskView;
	}
	
	//Added ModelMap and Called GetAllTasks Method from Service Class
	@PostMapping(path = "/displaytask")
	public ModelAndView displayTask(ModelMap model, @ModelAttribute TaskManagerEntity taskEntity) {
		taskRepo.save(taskEntity);
		String taskName = (String) model.get("taskName");
		Iterable<TaskManagerEntity> tasks = taskService.GetAllTasks();
		if(taskEntity.getTaskName() != null && taskEntity.getTaskDescription() != null) {
			model.put("tasks", taskService.GetAllTasks()); //Displays the names of tasks to the JSP Page
			return displayTaskView;
		}
		return createTaskFailedView;
	}
	
	@GetMapping(path = "/updatetask")
	public ModelAndView updateTask() {
		return updateTaskView;
	}
	
	@PostMapping(path = "/updatetaskpassed")
	public ModelAndView taskUpdated(@ModelAttribute TaskManagerEntity taskEntity) {
		taskRepo.save(taskEntity);
		Iterable<TaskManagerEntity> newEntity = taskRepo.findAll();
		for(TaskManagerEntity myEntity : newEntity) {
			if(myEntity.getTaskName().equals(taskEntity.getTaskName())) {
				taskRepo.deleteAll();
				taskEntity.setEmail(myEntity.getEmail());
				taskEntity.setTaskName(myEntity.getTaskName());
				taskEntity.setTaskDescription(myEntity.getTaskDescription());
				taskEntity.setStartDate(myEntity.getStartDate());
				taskEntity.setEndDate(myEntity.getEndDate());
				taskEntity.setSeverity(myEntity.getSeverity());
				taskRepo.save(taskEntity);
				return updateTaskPassedView;
			}
		}
		return updateTaskFailedView;
	}
	
	@GetMapping(path = "/deletetask")
	public ModelAndView deleteTask() {
		return deleteTaskView;
	}
	
	@PostMapping(path = "/deletetaskpassed")
	public ModelAndView taskDeleted(@ModelAttribute TaskManagerEntity taskEntity) {
		Iterable<TaskManagerEntity> newEntity = taskRepo.findAll();
		for(TaskManagerEntity myEntity : newEntity) {
			if(myEntity.getTaskName().equals(taskEntity.getTaskName())) {
				taskRepo.deleteById(myEntity.getTaskID());
				return deleteTaskPassedView;
			}
		}
		return deleteTaskFailedView;
	}
}
