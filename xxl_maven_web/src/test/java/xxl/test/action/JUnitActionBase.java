package xxl.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 说明： JUnit测试action时使用的基类
 * 
 * @author 赵磊
 * @version 创建时间：2011-2-2 下午10:27:03
 */
public class JUnitActionBase {
	private static HandlerMapping handlerMapping;
	private static HandlerAdapter handlerAdapter;

	/**
	 * 读取spring4 MVC配置文件
	 */
	@BeforeClass
	public static void setUp() {
		if (handlerMapping == null) {
			String[] configs = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" };
			XmlWebApplicationContext context = new XmlWebApplicationContext();
			context.setConfigLocations(configs);
			MockServletContext msc = new MockServletContext();
			context.setServletContext(msc);
			context.refresh();
			msc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,context);
			handlerAdapter = (HandlerAdapter) context.getBean(context.getBeanNamesForType(RequestMappingHandlerAdapter.class)[0]);
			handlerMapping = (HandlerMapping) context.getBean(RequestMappingHandlerMapping.class);
		}
	}

	/**
	 * 执行request对象请求的action
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView excuteAction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HandlerExecutionChain chain = handlerMapping.getHandler(request);
		final ModelAndView model = handlerAdapter.handle(request, response,chain.getHandler());
		return model;
	}
}
