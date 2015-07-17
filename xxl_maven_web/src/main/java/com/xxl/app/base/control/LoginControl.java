package com.xxl.app.base.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("login")
public class LoginControl {

	@RequestMapping("test")
	@ResponseBody
	public String testLogin(HttpServletRequest request){
		System.out.println("test login");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("result", "test Success");
		return JSONObject.fromObject(map).toString();
	}
}
