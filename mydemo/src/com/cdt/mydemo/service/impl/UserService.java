package com.cdt.mydemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdt.mydemo.dao.IUserDao;
import com.cdt.mydemo.entity.User;
import com.cdt.mydemo.service.IUserService;
/**
 * 
 * @ClassName: UserServiceImpl   
 * @Description: TODO  
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public String addUser(User user) throws Exception {
		return userDao.addUser(user);
	}

	@Override
	public String updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public User findById(String id) throws Exception {
		return userDao.findById(id);
	}

	@Override
	public void deletUser(String id) throws Exception {
		userDao.deletUser(id);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return userDao.findUserList();
	}

}
