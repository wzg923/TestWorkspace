package com.cdt.mydemo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdt.mydemo.dao.IUserDao;
import com.cdt.mydemo.entity.User;
import com.cdt.mydemo.mapper.UserMapper;
/**
 * 
 * @ClassName: UserDaoImpl   
 * @Description: TODO  
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String addUser(User user) throws Exception {
		userMapper.addUser(user);
		return "success";
	}

	@Override
	public String updateUser(User user) throws Exception {
		userMapper.updateUser(user);
		return "success";
	}

	@Override
	public User findById(String id) throws Exception {
		User user = userMapper.findById(id);
		return user;
	}

	@Override
	public void deletUser(String id) throws Exception {
		userMapper.deletUser(id);
	}

	@Override
	public List<User> findUserList() throws Exception {
		List<User> userList = userMapper.findUserList();
		return userList;
	}

}
