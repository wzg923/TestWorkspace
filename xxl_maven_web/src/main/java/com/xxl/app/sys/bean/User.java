package com.xxl.app.sys.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String userName;
	private int id;
	private Set<Role> roles = new HashSet<Role>();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
