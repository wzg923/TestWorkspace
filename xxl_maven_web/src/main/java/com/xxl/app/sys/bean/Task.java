package com.xxl.app.sys.bean;

import java.util.Date;

/**
 * 任务bean
 * @author Administrator
 *
 */
public class Task {

	private int id;
	private String taskName;
	private String flowId;
	private String bussinessId;
	private String state;
	private String preState;
	private int applyUser;
	private int updateUser;
	private Date createTime;
	private Date updateTime;
	private String icon;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(String bussinessId) {
		this.bussinessId = bussinessId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPreState() {
		return preState;
	}
	public void setPreState(String preState) {
		this.preState = preState;
	}
	public int getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(int applyUser) {
		this.applyUser = applyUser;
	}
	public int getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
