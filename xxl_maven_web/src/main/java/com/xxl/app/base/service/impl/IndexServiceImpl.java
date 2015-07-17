package com.xxl.app.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.app.base.dao.IIndexDao;
import com.xxl.app.base.service.IIndexService;

/**
 * index 逻辑处理实现类
 * @author Administrator
 *
 */
@Service
public class IndexServiceImpl implements IIndexService{

	@Autowired
	private IIndexDao indexDao;
	
	public void doIndex() {
		System.out.println("doIndex");
		indexDao.queryIndex();
	}

}
