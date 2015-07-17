package xxl.test;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageWriter;

import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramCanvas;
import org.junit.Assert;
import org.junit.Test;

import com.xxl.app.base.activiti.ActivitiVariable;

public class MyBpmTest extends BaseTestCase{
	
	@Test
	public void Test() throws IOException{
		//部署流程
		//Deployment deploy = deployProcess(readXmlFile());
		//System.out.println("id:"+deploy.getId());
		//启动流程,将第一个任务赋给用户ID为1
		ActivitiVariable var = startProcessInstanceByKey("demo_2","1");
		System.out.println("getActivityId:"+runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(var.getBussineesId()).singleResult().getActivityId());
		//ActivitiVariable var = new ActivitiVariable();
		//var.setBussineesId("7a02e1c2-527d-4093-9a14-8e4633fb92da");
		Assert.assertNotNull(var);
		System.out.println("id:"+var.getId()+"bisId:"+var.getBussineesId());
		
		//找到用户id为1的流程任务
		var.setUserId("1");
		Task task= getProcessTask(var);
		System.out.println("taskId:"+task.getId()+" taskName:"+task.getName()+" Assignee:"+task.getAssignee());
		//完成第一个任务
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("roleId", "2");//任务赋给角色为2的用户
		var.setMap(map);
		completeProcessTask(task, var);
		System.out.println("getActivityId:"+runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(var.getBussineesId()).singleResult().getActivityId());
		
		//找到角色为2的流程任务
		var.setRoleId("2");
		task= getProcessTask(var);
		System.out.println("taskId:"+task.getId()+" taskName:"+task.getName()+" Assignee:"+task.getAssignee());
		//完成第二个任务
		map.clear();
		//map.put("pass", true);//批准，流程结束
		//var.setMap(map);
		//completeProcessTask(task, var);
		map.put("pass", false);//不批准，查看任务
		map.put("id", "3");
		var.setMap(map);
		completeProcessTask(task, var);
		System.out.println("getActivityId:"+runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(var.getBussineesId()).singleResult().getActivityId());
		
		
		//不批准时查找任务
		var.setUserId("3");
		task = getProcessTask(var);
		System.out.println("taskId:"+task.getId()+" taskName:"+task.getName()+" Assignee:"+task.getAssignee());
		map.clear();
		map.put("id", "4");
		var.setMap(map);
		completeProcessTask(task, var);
		System.out.println("getActivityId:"+runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(var.getBussineesId()).singleResult().getActivityId());
		
		//回到任务1
		var.setUserId("4");
		task = getProcessTask(var);
		System.out.println("taskId:"+task.getId()+" taskName:"+task.getName()+" Assignee:"+task.getAssignee());
		//完成第一个任务
		map.clear();
		map.put("roleId", "2");
		var.setMap(map);
		completeProcessTask(task, var);
		System.out.println("getActivityId:"+runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(var.getBussineesId()).singleResult().getActivityId());
		
		//找到角色为2的流程任务
		var.setRoleId("2");
		task= getProcessTask(var);
		System.out.println("taskId:"+task.getId()+" taskName:"+task.getName()+" Assignee:"+task.getAssignee());
		//完成第二个任务
		map.clear();
		map.put("pass", true);//批准，流程结束
		var.setMap(map);
		completeProcessTask(task, var);
		
		System.out.println("getActivityId:"+runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(var.getBussineesId()).singleResult().getActivityId());
	}
	
	public InputStream readXmlFile() throws IOException{
        String filePath="demo.bpmn";
        System.out.println(Class.class.getClass().getResource("/").getFile().toString());
        return Class.class.getClass().getResource("/"+filePath).openStream();
	}
	
	public void createImage(String fileName,Task task){
		File file = new File("D:/"+fileName);
		//ProcessDefinition pd = repositoryService.getProcessDefinition(task.getProcessDefinitionId());
		
		Map<String, Object> coordinates = new HashMap<String, Object>();
		// 1. 获取到当前活动的ID
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
		String currentActivitiId = pi.getActivityId();
		// 2. 获取到流程定义
		ProcessDefinitionEntity pd = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(task.getProcessDefinitionId());
		// 3. 使用流程定义通过currentActivitiId得到活动对象
		ActivityImpl activity = pd.findActivity(currentActivitiId);
		// 4. 获取活动的坐标
		coordinates.put("x", activity.getX());
		coordinates.put("y", activity.getY());
		coordinates.put("width", activity.getWidth());
		coordinates.put("height", activity.getHeight());
	}
	
	public void getProcessImag() throws IOException{
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionKey("demo_2").singleResult();
		String diagramResourceName = pd.getDiagramResourceName();  
        InputStream imageStream = repositoryService.getResourceAsStream(pd.getDeploymentId(), diagramResourceName);
        File file = new File("D:/"+diagramResourceName);
        int len;
        DefaultProcessDiagramCanvas dpd = new DefaultProcessDiagramCanvas(800, 400, 10, 10, "png");
	}
}
