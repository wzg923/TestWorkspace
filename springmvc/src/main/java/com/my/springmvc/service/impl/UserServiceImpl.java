package com.my.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.springmvc.dao.UserDao;
import com.my.springmvc.entity.User;
import com.my.springmvc.service.UserService;
/**
 * 
 * @ClassName: UserServiceImpl   
 * @Description: TODO  
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	public String addUser(User user) throws Exception {
		return userDao.addUser(user);
	}

	
	public String updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	
	public User findById(String id) throws Exception {
		return userDao.findById(id);
	}

	
	public void deletUser(String id) throws Exception {
		userDao.deletUser(id);
	}

	
	public List<User> findUserList() throws Exception {
		return userDao.findUserList();
	}

}
