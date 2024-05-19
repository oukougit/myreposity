package com.sanqing.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.User;
import com.sanqing.service.UserService;

public class Register extends ActionSupport{
	
	private Integer userId;			//�û����
	private String username;		//�û���
	private String password;		//����
	private String name;			//����
	private Byte sex;				//�Ա�
	private String address;			//סַ
	private String phone;			//��ϵ�绰
	private String post;			//�ʼĵ�ַ
	private String email;			//Email��ַ
	private Date regTime;			//ע��ʱ��
	private String regIpAddress;	//ע��IP��ַ
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
			request.setAttribute("error", "�˺Ż����벻��Ϊ��");
			return ERROR;
			}
		else if(userService.register(user) == false) {
			request.setAttribute("error", "��ã��˺��Ѿ�����ע���");
			return ERROR;
		}
		return SUCCESS;
		
	}
}
