package com.sanqing.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.User;
import com.sanqing.service.UserService;

public class Register extends ActionSupport{
	
	private Integer userId;			//用户编号
	private String username;		//用户名
	private String password;		//密码
	private String name;			//姓名
	private Byte sex;				//性别
	private String address;			//住址
	private String phone;			//联系电话
	private String post;			//邮寄地址
	private String email;			//Email地址
	private Date regTime;			//注册时间
	private String regIpAddress;	//注册IP地址
	private UserService userService;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte getSex() {
		return sex;
	}
	public void setSex(Byte sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public String getRegIpAddress() {
		return regIpAddress;
	}
	public void setRegIpAddress(String regIpAddress) {
		this.regIpAddress = regIpAddress;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	public String execute() throws Exception {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setAddress(address);
		user.setEmail(email);
		user.setPhone(phone);
		user.setRegIpAddress(regIpAddress);
		user.setRegTime(regTime);
		user.setSex(sex);
		user.setPost(post);
		
		
		System.out.println("-----------------------"+user.getUsername());
		System.out.println(user.getPassword());
		
		System.out.println(user);
		System.out.println(user);
		System.out.println(user);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if(("").equals(username) || ("").equals(password)) {
			request.setAttribute("error", "账号或密码不能为空");
			return ERROR;
			}
		else if(userService.register(user) == false) {
			request.setAttribute("error", "你好，账号已经被人注册过");
			return ERROR;
		}
		return SUCCESS;
		
	}
}
