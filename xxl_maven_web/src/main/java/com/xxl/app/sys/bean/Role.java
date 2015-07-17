package com.xxl.app.sys.bean;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private String roleName;
	private int id;
	private Set<User> users = new HashSet<User>();
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
