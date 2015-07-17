package com.xxl.app.base.dao.provider;

public class SqlProvider {

	public String queryIndex(){
		return "select sysdate() from dual";
	}
}
