package com.sanqing.dao;

import com.sanqing.po.Admin;
import com.sanqing.po.Commodity;
import com.sanqing.po.User;

public interface UserDAO {
	public boolean check(User user);//�û���¼

	public void add(User user);//�û�ע��
	
	public boolean checkAndAdd(User user);
}
