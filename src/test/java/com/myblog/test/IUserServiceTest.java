package com.myblog.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myblog.model.User;
import com.myblog.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class IUserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getUserAll() {
		List<User> users =userService.getAllUserMessage();
		
		for (User user : users) {
			System.out.println(user.toString());
		}
		
	}

}
