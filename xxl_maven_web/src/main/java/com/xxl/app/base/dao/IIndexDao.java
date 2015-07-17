package com.xxl.app.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.xxl.app.base.dao.provider.SqlProvider;

public interface IIndexDao extends SqlMapper{

	@SelectProvider(type=SqlProvider.class,method="queryIndex")
	public abstract List<Map<String,Object>> queryIndex();
}
