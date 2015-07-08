package com.my.springmvc.dao;

import java.util.List;

import com.my.springmvc.entity.User;


public interface UserDao{

	/**
	 * 
	 * @Title: addUser   
	 * @Description: 新增用户
	 * @param @param user
	 * @param @return
	 * @param @throws Exception  
	 * @return String  
	 * @throws
	 */
	public String addUser(User user)throws Exception;
	
	/**
	 * 
	 * @Title: updateUser   
	 * @Description: 修改用户
	 * @param @param user
	 * @param @return
	 * @param @throws Exception  
	 * @return String  
	 * @throws
	 */
	public String updateUser(User user) throws Exception;
	
	/**
	 * 
	 * @Title: findById   
	 * @Description: 根据用户ID查询
	 * @param @param id
	 * @param @return
	 * @param @throws Exception  
	 * @return User  
	 * @throws
	 */
	public User findById(String id) throws Exception;
	
	/**
	 * 
	 * @Title: deletUser   
	 * @Description: 商户用户
	 * @param @param id
	 * @param @throws DataAccessException  
	 * @return void  
	 * @throws
	 */
	public void deletUser(String id) throws Exception;
	
	/**
	 * 
	 * @Title: findUserList   
	 * @Description: 查询所有用户
	 * @param @return
	 * @param @throws DataAccessException  
	 * @return List<User>  
	 * @throws
	 */
	public List<User> findUserList() throws  Exception;
}
