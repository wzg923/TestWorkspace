package com.xxl.app.base.util;

import java.io.InputStream;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxl.app.base.activiti.ActivitiVariable;

/**
 * activiti工具类
 * @author Administrator
 *
 */
public class ActivitiUtil {

	 @Autowired
	 private RuntimeService runtimeService;
	 @Autowired
     private RepositoryService repositoryService;
	 @Resource 
     TaskService taskService;
	
	 /**
	  * 通过key启动流程
	  * @param key
	  * @return
	  */
	 public ActivitiVariable startProcessInstanceByKey(String key){
		 ActivitiVariable var = new ActivitiVariable();
		 ProcessInstance instance = runtimeService.startProcessInstanceByKey(key);
		 var.setId(instance.getId());
		 var.setBussineesId(instance.getBusinessKey());
		 return var;
	 }
	 
	 /**
	  * 部署流程
	  * @param is
	  */
	 public Deployment deployProcess(InputStream is){
		 Deployment deployment = repositoryService.createDeployment().addInputStream("bpmn20.xml", is).deploy();
		 return deployment;
	 }
	 
	 public Task getProcessTask(ActivitiVariable var){
		 String bussinessId = var.getBussineesId();
		 //ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(bussinessId).singleResult();
		 Task task = null;
		 String userId = var.getUserId();
		 if(StringUtils.isNoneBlank(userId)){
			 task = taskService.createTaskQuery().processDefinitionKey(bussinessId).taskAssignee(userId).singleResult();
			 if(task==null){
				 taskService.createTaskQuery().processDefinitionKey(bussinessId).taskCandidateUser(userId).singleResult();
			 }
			 if(task!=null){
				 taskService.claim(task.getId(), userId);
				 return task;
			 }
		 }
		 String roleId = var.getRoleId();
		 if(StringUtils.isNoneBlank(roleId)){
			 task = taskService.createTaskQuery().processDefinitionKey(bussinessId).taskCandidateGroup(roleId).singleResult();
			 if(task!=null){
				 taskService.claim(task.getId(), roleId);
				 return task;
			 }
		 }
		 return null;
	 }
	 
	 public void completeProcessTask(Task task,ActivitiVariable var){
		 if(task!=null){
			 taskService.complete(task.getId(), var.getMap());
		 }else{
			 throw new NullPointerException();
		 }
	 }
}
