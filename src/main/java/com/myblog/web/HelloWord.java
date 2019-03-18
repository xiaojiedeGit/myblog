package com.myblog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myblog.model.User;
import com.myblog.service.UserService;

@Controller
public class HelloWord {
	
	@Autowired
	private UserService service;

	
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUser() {
		return service.getAllUserMessage();
	}
	
	
	
}
