package com.task.TaskManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tasks")
@Entity
public class TaskManagerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaskID")
	private Integer taskID;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "TaskName")
	private String taskName;
	
	@Column(name = "TaskDescription")
	private String taskDescription;
	
	@Column(name = "StartDate")
	private String startDate;
	
	@Column(name = "EndDate")
	private String endDate;
	
	@Column(name = "Severity")
	private String severity;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	//Added toString method to convert object name into a String from the displaytask JSP Page
	public String toString() {
		return this.taskName;
	}
}
