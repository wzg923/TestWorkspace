package com.my.springmvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.springmvc.dao.UserDao;
import com.my.springmvc.entity.User;
import com.my.springmvc.mapper.UserMapper;
/**
 * 
 * @ClassName: UserDaoImpl   
 * @Description: TODO  
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;
	
	public String addUser(User user) throws Exception {
		userMapper.addUser(user);
		return "success";
	}

	
	public String updateUser(User user) throws Exception {
		userMapper.updateUser(user);
		return "success";
	}

	
	public User findById(String id) throws Exception {
		User user = userMapper.findById(id);
		return user;
	}

	
	public void deletUser(String id) throws Exception {
		userMapper.deletUser(id);
	}

	
	public List<User> findUserList() throws Exception {
		List<User> userList = userMapper.findUserList();
		return userList;
	}
	

}
