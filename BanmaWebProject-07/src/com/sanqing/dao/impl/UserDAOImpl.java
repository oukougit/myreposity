package com.sanqing.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.dao.UserDAO;

import com.sanqing.po.User;


public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{

	public boolean check(User user) {
		    
		    System.out.println(user + "");
		    System.out.println(user + "");
		    System.out.println(user + "");
		    System.out.println(user + "");
		    System.out.println(user + "");
			
			Session session = getSession();		//获得session对象
			
			Query query = session.createQuery("FROM User WHERE username = :username AND password = :password");//执行查询
			query.setParameter("username", user.getUsername());
	        query.setParameter("password", user.getPassword());
			
	        
	 
	          if( (User) query.uniqueResult() == null) {
	        	  return false;
	          }
	          else {
	        	  return true;
	          }
		    }

	@Override
	public void add(User user) {
		getHibernateTemplate().save(user);//保存实体

			}

	@Override
	public boolean checkAndAdd(User user) {
		
		//String username = user.getUsername();
		Session session = getSession();		//获得session对象
		Query query = session.createQuery("FROM User WHERE username = :username "
				+ "AND password = :password "
				+ "AND name = :name "
				+ "AND sex = :sex "
				+ "AND address = :address "
				+ "AND phone = :phone "
				+ "AND post = :post "
				+ "AND email = :email "
				+ "AND regTime = :regTime "
				+ "AND regIpAddress = :regIpAddress "
				);//执行查询
		
		query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        query.setParameter("name", user.getName());
        query.setParameter("sex", user.getSex());
        query.setParameter("address", user.getAddress());
        query.setParameter("phone", user.getPhone());
        query.setParameter("post", user.getPost());
        query.setParameter("email", user.getEmail());
        query.setParameter("regTime", user.getRegTime());
        query.setParameter("regIpAddress", user.getRegIpAddress());
        
        System.out.println(user.getEmail());
        System.out.println(user.getEmail());
        System.out.println(user.getEmail());
        System.out.println(user);
		
		 if( (User) query.uniqueResult() == null) {
			 
		 this.add(user);
		 
       	  return true;
         }
         else {
       	  return false;
         }
			
			
			
	}
	
}
	


