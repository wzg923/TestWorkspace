package com.my.springmvc.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.springmvc.entity.User;
import com.my.springmvc.service.LoginService;

@Controller
/*@RequestMapping("/login")*/
public class LoginController {
	
	@Autowired(required = true)
	LoginService loginService;	


	/**@RequestMapping("/hello")注解标记一个访问的路径/index,
	 * return "index"标记返回视图（index.jsp）；*/
	@RequestMapping("/index")
	public ModelAndView hello(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			User user) {
		//model.addAttribute("name", name);
		ModelAndView mav=new ModelAndView("redirect:../index");
		return  mav;
	}

	// 定义method方法不是必须的 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(PrintWriter out, User user,
			HttpServletRequest req, HttpServletResponse response) {
		//out.println(user.getName() + "login begin!");
		boolean res = loginService.login(user);
		if (res) {
			//out.println(user.getName() + "login success!");
			ModelAndView mav=new ModelAndView("home");
			return mav;
		} else {
			//out.println(user.getName() + "login failed!");
			
			return null;
		}
	}
}
