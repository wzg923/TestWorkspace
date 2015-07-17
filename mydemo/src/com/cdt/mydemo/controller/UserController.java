package com.cdt.mydemo.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cdt.mydemo.entity.User;
import com.cdt.mydemo.service.IUserService;





@Controller
@RequestMapping("/sysManage/user")
public class UserController {
	private static final Log log = LogFactory.getLog(UserController.class);
	@Autowired(required = true)
	private IUserService userService;


	/**
	 * 
	 * @Title: addUser   
	 * @Description: 新增用户
	 * @param @param user
	 * @param @param request
	 * @param @return  
	 * @return ModelAndView  
	 * @throws
	 */
	@RequestMapping("adduser")
	public ModelAndView addUser(User user){
		user.setId(String.valueOf(new java.util.Date().getTime()));
		try {
			userService.addUser(user);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/sysManage/user/userlist.spr");
		return modelAndView;
	} 
	
	/**
	 * 
	 * @Title: updateUser   
	 * @Description: 更新用户
	 * @param @param user
	 * @param @return  
	 * @return ModelAndView  
	 * @throws
	 */
	@RequestMapping("updateUser")
	public ModelAndView updateUser(User user){
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("updateUser");
		mav.addObject("user",user);
		return mav;
	}
	
	/**
	 * 
	 * @Title: findById   
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return  
	 * @return ModelAndView  
	 * @throws
	 */
	@RequestMapping("findUserById")
	public ModelAndView findById(String id){
		User user = null;
		try {
			user = userService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("updateUser");
		mav.addObject("user",user);
		return mav;
	}
	
	/**
	 * 
	 * @Title: deletUser   
	 * @Description: 删除用户
	 * @param @param id
	 * @param @return  
	 * @return ModelAndView  
	 * @throws
	 */
	@RequestMapping("deleteuser")
	public ModelAndView deletUser( String id){
		try {
			userService.deletUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/sysManage/user/userlist.spr");
		return modelAndView;
	}
	
	@RequestMapping("userlist")
	public ModelAndView findUserList(){
		List<User> userList = null;
		try {
			userList = userService.findUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("userLists");
		mav.addObject("userList", userList);
		return mav;
	}
	
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("add")
	public ModelAndView add(){
		ModelAndView mav = new ModelAndView("addUser");
		return mav;
	}
}

