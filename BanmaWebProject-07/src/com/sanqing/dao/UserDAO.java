package com.sanqing.dao;

import com.sanqing.po.Admin;
import com.sanqing.po.Commodity;
import com.sanqing.po.User;

public interface UserDAO {
	public boolean check(User user);//用户登录

	public void add(User user);//用户注册
	
	public boolean checkAndAdd(User user);
}
