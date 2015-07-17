package xxl.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.xxl.app.base.service.IIndexService;

@ContextConfiguration(locations={"classpath:applicationContext-bean.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//如果是true不会改变数据库数据，如果是false会改变数据
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class IndexService {
	
	@Autowired
	private IIndexService indexService;
	
	@Test
	public void TestIndex(){
		
		indexService.doIndex();
	}

}
