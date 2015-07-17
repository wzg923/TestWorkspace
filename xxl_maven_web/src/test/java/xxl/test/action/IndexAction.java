package xxl.test.action;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.xxl.app.base.service.IIndexService;


/** 
* 说明： 测试OrderAction的例子
* 
* @author  赵磊 
* @version 创建时间：2011-2-2 下午10:26:55  
*/ 

public class IndexAction extends JUnitActionBase {
	
	@Autowired
	private IIndexService indexService;
	
	@Test
	public void testAdd() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setServletPath("/index.html");
		//request.addParameter("id", "1002");
		//request.addParameter("date", "2010-12-30");
		//request.setMethod("POST");
		// 执行URI对应的action
		final ModelAndView mav = this.excuteAction(request, response);
		// Assert logic
		Assert.assertEquals("/index.html", mav.getViewName());
		String msg=(String)request.getAttribute("msg");
		System.out.println(msg);
	}
}