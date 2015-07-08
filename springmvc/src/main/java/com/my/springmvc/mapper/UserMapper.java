package com.my.springmvc.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.my.springmvc.entity.User;

/**
 * 
 * @ClassName: UserMapper   
 * @Description: 用户表对应的数据库表名为:USER的Mapper(数据库操作)类
 */
public interface UserMapper{

	/**
	 * 
	 * @Title: addUser   
	 * @Description: 新增用户 
	 * @param @param user
	 * @param @throws DataAccessException  
	 * @return void  
	 * @throws
	 */
	public void addUser(User user) throws DataAccessException; 
	
	/**
	 * 
	 * @Title: updateUser   
	 * @Description: 修改用户
	 * @param @param user
	 * @param @throws DataAccessException  
	 * @return void  
	 * @throws
	 */
	public void updateUser(User user) throws DataAccessException;
	
	/**
	 * 
	 * @Title: findById   
	 * @Description: 根据id查询用户
	 * @param @param id
	 * @param @return
	 * @param @throws DataAccessException  
	 * @return User  
	 * @throws
	 */
	public User findById(String id) throws DataAccessException;
	
	/**
	 * 
	 * @Title: deletUser   
	 * @Description: 商户用户
	 * @param @param id
	 * @param @throws DataAccessException  
	 * @return void  
	 * @throws
	 */
	public void deletUser(String id) throws DataAccessException;
	
	/**
	 * 
	 * @Title: findUserList   
	 * @Description: 查询所有用户
	 * @param @return
	 * @param @throws DataAccessException  
	 * @return List<User>  
	 * @throws
	 */
	public List<User> findUserList() throws DataAccessException;
}
