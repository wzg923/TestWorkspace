package com.xxl.app.base.activiti;

import java.util.Map;

/**
 * activiti流程变量
 * @author Administrator
 *
 */
public class ActivitiVariable {

	private String bussineesId;
	private String id;
	private String approveFlag;
	private String userId;
	private String roleId;
	private Map<String,Object> map;
	public String getBussineesId() {
		return bussineesId;
	}
	public void setBussineesId(String bussineesId) {
		this.bussineesId = bussineesId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApproveFlag() {
		return approveFlag;
	}
	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
}
