package com.cdt.mydemo.entity;

import java.util.List;


/**
 * @author wzx
 *
 */
public  class User {
	private String id;
	private String loginName;
	private String name;
	private String password;
	private String active;
	private int order;
	private String cppccUnit="2";

	
	public String getId() {
		return id;
	}

	private List<Role> roles;

	
	private String level;
	
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	private String deptId;
	
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCppccUnit() {
		return cppccUnit;
	}
	public void setCppccUnit(String cppccUnit) {
		this.cppccUnit = cppccUnit;
	}
}
