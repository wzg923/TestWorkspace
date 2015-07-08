package com.my.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.springmvc.dao.UserDao;
import com.my.springmvc.entity.User;
import com.my.springmvc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	/**
	 * 使用@Autowired注解标注userDAO变量， 当需要使用UserDAO时，Spring就会自动注入UserDAO
	 */
	@Autowired
	private UserDao userDao;// 注入dao

	public boolean login(User user) {
		if("admin".equals(user.getName()) &&
				"111111".equals(user.getPassword())){
			return true;
		}else return false;

	}

	/*public UserDao getUserDAO() {
		return userDao;
	}

	public void setUserDAO(UserDao userDao) {
		this.userDao = userDao;
	}*/
	
	

}
