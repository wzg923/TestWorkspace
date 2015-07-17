package xxl.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.xxl.app.base.activiti.ActivitiVariable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-activiti.xml",
		"classpath:applicationContext-bean.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class BaseTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	@Test
	public void test() {
		System.out.println("test");
	}

	@Autowired
	RuntimeService runtimeService;
	@Autowired
	RepositoryService repositoryService;
	@Resource
	TaskService taskService;

	/**
	 * 通过key启动流程
	 * 
	 * @param key
	 * @return
	 */
	public ActivitiVariable startProcessInstanceByKey(String key, String id) {
		ActivitiVariable var = new ActivitiVariable();
		UUID uuid = java.util.UUID.randomUUID();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(
				key, uuid.toString(), map);
		var.setId(instance.getId());
		var.setBussineesId(instance.getBusinessKey());
		return var;
	}

	/**
	 * 部署流程
	 * 
	 * @param is
	 */
	public Deployment deployProcess(InputStream is) {
		Deployment deployment = repositoryService.createDeployment()
				.addInputStream("bpmn20.xml", is).deploy();
		return deployment;
	}

	public Task getProcessTask(ActivitiVariable var) {
		String bussinessId = var.getBussineesId();
		// ProcessInstance processInstance =
		// runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(bussinessId).singleResult();
		Task task = null;
		String userId = var.getUserId();
		if (StringUtils.isNoneBlank(userId)) {
			task = taskService.createTaskQuery()
					.processInstanceBusinessKey(bussinessId)
					.taskAssignee(userId).singleResult();
			if (task == null) {
				taskService.createTaskQuery()
						.processInstanceBusinessKey(bussinessId)
						.taskCandidateUser(userId).singleResult();
			}
			if (task != null) {
				taskService.claim(task.getId(), userId);
				return task;
			}
		}
		String roleId = var.getRoleId();
		if (StringUtils.isNoneBlank(roleId)) {
			task = taskService.createTaskQuery()
					.processInstanceBusinessKey(bussinessId)
					.taskCandidateGroup(roleId).singleResult();
			if (task != null) {
				taskService.claim(task.getId(), roleId);
				return task;
			}
		}
		return null;
	}

	public void completeProcessTask(Task task, ActivitiVariable var) {
		if (task != null) {
			taskService.complete(task.getId(), var.getMap());
		} else {
			throw new NullPointerException();
		}
	}
}