package com.xxl.app.sys.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="user")
public class UserAction {

	public String toLogin(Model model){
		
		
		return "login.html";
	}
}
