/*package com.xxl.app.base.activiti;

import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxl.app.sys.bean.Role;
import com.xxl.app.sys.bean.User;

@Service
@Transactional
public class AccountServiceImpl implements AccountService { 
    *//**
     * 保存用户信息，并且同步用户信息到activiti的identity.User和identify.Group
     * @param user              用户对象{@link User}
     * @param roleIds           用户拥有的角色ID集合
     * @param synToActiviti     是否同步数据到Activiti
     * @see Role
     *//*
    public void saveUser(User user, List<Long> roleIds, boolean synToActiviti) {
        String userId = ObjectUtils.toString(user.getId());
 
        // 保存系统用户
        accountManager.saveEntity(user);
 
        // 同步数据到Activiti Identify模块
        if (synToActiviti) {
            UserQuery userQuery = identityService.createUserQuery();
            List<org.activiti.engine.identity.user> activitiUsers = userQuery.userId(userId).list();
 
            if (activitiUsers.size() == 1) {
                updateActivitiData(user, roleIds, activitiUsers.get(0));
            } else if (activitiUsers.size() > 1) {
                String errorMsg = "发现重复用户：id=" + userId;
                logger.error(errorMsg);
                throw new RuntimeException(errorMsg);
            } else {
                newActivitiUser(user, roleIds);
            }
        }
 
    }
 
    *//**
     * 添加工作流用户以及角色
     * @param user      用户对象{@link User}
     * @param roleIds   用户拥有的角色ID集合
     *//*
    private void newActivitiUser(User user, List<Long> roleIds) {
        String userId = user.getId()+"";
 
        // 添加用户
        saveActivitiUser(user);
 
        // 添加membership
        addMembershipToIdentify(roleIds, userId);
    }
 
    *//**
     * 添加一个用户到Activiti {@link org.activiti.engine.identity.User}
     * @param user  用户对象, {@link User}
     *//*
    private void saveActivitiUser(User user) {
        String userId = user.getId().toString();
        org.activiti.engine.identity.User activitiUser = identityService.newUser(userId);
        cloneAndSaveActivitiUser(user, activitiUser);
        logger.debug("add activiti user: {}", ToStringBuilder.reflectionToString(activitiUser));
    }
 
    *//**
     * 添加Activiti Identify的用户于组关系
     * @param roleIds   角色ID集合
     * @param userId    用户ID
     *//*
    private void addMembershipToIdentify(List<Long> roleIds, String userId) {
        for (Long roleId : roleIds) {
            Role role = roleManager.getEntity(roleId);
            logger.debug("add role to activit: {}", role);
            identityService.createMembership(userId, role.getEnName());
        }
    }
 
    *//**
     * 更新工作流用户以及角色
     * @param user          用户对象{@link User}
     * @param roleIds       用户拥有的角色ID集合
     * @param activitiUser  Activiti引擎的用户对象，{@link org.activiti.engine.identity.User}
     *//*
    private void updateActivitiData(User user, List<Long> roleIds, org.activiti.engine.identity.User activitiUser) {
 
        String userId = user.getId().toString();
 
        // 更新用户主体信息
        cloneAndSaveActivitiUser(user, activitiUser);
 
        // 删除用户的membership
        List<group> activitiGroups = identityService.createGroupQuery().groupMember(userId).list();
        for (Group group : activitiGroups) {
            logger.debug("delete group from activit: {}", ToStringBuilder.reflectionToString(group));
            identityService.deleteMembership(userId, group.getId());
        }
 
        // 添加membership
        addMembershipToIdentify(roleIds, userId);
    }
 
    *//**
     * 使用系统用户对象属性设置到Activiti User对象中
     * @param user          系统用户对象
     * @param activitiUser  Activiti User
     *//*
    private void cloneAndSaveActivitiUser(User user, org.activiti.engine.identity.User activitiUser) {
        activitiUser.setFirstName(user.getName());
        activitiUser.setLastName(StringUtils.EMPTY);
        activitiUser.setPassword(StringUtils.EMPTY);
        activitiUser.setEmail(user.getEmail());
        identityService.saveUser(activitiUser);
    }
 
    @Override
    public void delete(Long userId, boolean synToActiviti, boolean synToChecking) throws ServiceException, Exception {
        // 查询需要删除的用户对象
        User user = accountManager.getEntity(userId);
        if (user == null) {
            throw new ServiceException("删除用户时，找不到ID为" + userId + "的用户");
        }
 
        *//**
         * 同步删除Activiti User Group
         *//*
        if (synToActiviti) {
            // 同步删除Activiti User
            List<role> roleList = user.getRoleList();
            for (Role role : roleList) {
                identityService.deleteMembership(userId.toString(), role.getEnName());
            }
 
            // 同步删除Activiti User
            identityService.deleteUser(userId.toString());
        }
 
        // 删除本系统用户
        accountManager.deleteUser(userId);
 
        // 删除考勤机用户
        if (synToChecking) {
            checkingAccountManager.deleteEntity(userId);
        }
    }
}
*/