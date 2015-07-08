package com.my.springmvc.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringContextHolder {
	private static ApplicationContext applicationContext;
	private SpringContextHolder(){
		if(null == applicationContext){
			applicationContext=new AnnotationConfigApplicationContext(SpringContextHolder.class);
		}
	}
	
	public static Class<?> getBean(Class<?> c){
		return applicationContext.getBean(c.getClass());	
	}
	
	public static void main(String[] args){
		
	}
}
