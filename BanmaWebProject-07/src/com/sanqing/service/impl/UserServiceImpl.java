package com.sanqing.service.impl;

import com.sanqing.dao.UserDAO;
import com.sanqing.po.User;
import com.sanqing.service.UserService;


public class UserServiceImpl implements UserService{
	private UserDAO userDAO;//注入数据访问层

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean login(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getUsername());
		System.out.println(user.getUsername());
		System.out.println(user.getUsername());
		System.out.println(user.getUsername());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getPassword());
		System.out.println(user.getPassword());
		System.out.println(user.getPassword());
		System.out.println(user.getPassword());
		
		System.out.println(user);
		System.out.println(user);
		System.out.println(user);
		
		return userDAO.check(user);
	}

	@Override
	public boolean register(User user) {

	
		
		return userDAO.checkAndAdd(user);
	}
	

}
