package com.junit.spring;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haier.gems.security.dto.UserDTO;
import com.haier.gems.security.service.UserServiceClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath*:/spring/spring-dubbo.ml",
		"classpath*:/spring/spring-user-custom.xml",
		"classpath*:/spring/claim/ApplicationContext.xml"
		
})

public class UserServiceAdapterImplTest {
    @Autowired
    private UserServiceClient userServiceClientAdapter;
    @Test
    public void testGetUserById() {
        UserDTO userDTO = userServiceClientAdapter.getUserById(1L);
        assertThat(userDTO, notNullValue());
        assertThat(userDTO.getName(), equalTo("Kevin"));
        
    }
}