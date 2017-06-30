package com.excel.apps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="storedata")
public class StoreData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getAssignedTask() {
		return assignedTask;
	}
	public void setAssignedTask(String assignedTask) {
		this.assignedTask = assignedTask;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public String getAllocatedHrs() {
		return allocatedHrs;
	}
	public void setAllocatedHrs(String allocatedHrs) {
		this.allocatedHrs = allocatedHrs;
	}
	public String getActualHrs() {
		return actualHrs;
	}
	public void setActualHrs(String actualHrs) {
		this.actualHrs = actualHrs;
	}
	public String getExtraHrs() {
		return extraHrs;
	}
	public void setExtraHrs(String extraHrs) {
		this.extraHrs = extraHrs;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "projectName")
	private String projectName;
	
	@Column(name = "assignedTask")
	private String assignedTask;
	
	@Column(name = "taskDate")
	private String taskDate;
	
	@Column(name = "allocatedHrs")
	private String allocatedHrs;
	
	@Column(name = "actualHrs")
	private String actualHrs;
	
	@Column(name = "extraHrs")
	private String extraHrs;
	
	@Column(name = "remark")
	private String remark;
							
}
