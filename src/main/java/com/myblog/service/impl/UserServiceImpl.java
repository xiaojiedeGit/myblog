package com.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.dao.UserDao;
import com.myblog.model.User;
import com.myblog.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUserMessage() {
		List<User> users= userDao.getAllUserMessage();
		
		return users;
	}

	
	
}
