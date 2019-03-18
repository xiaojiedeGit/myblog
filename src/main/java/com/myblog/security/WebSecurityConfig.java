package com.myblog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import com.myblog.service.UserService;

public class WebSecurityConfig extends WebSecurityConfiguration{
	
	@Autowired
	private UserService userService;

}
