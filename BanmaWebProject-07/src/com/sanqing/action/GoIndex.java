package com.sanqing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Admin;
import com.sanqing.po.Commodity;
import com.sanqing.po.CommodityClass;
import com.sanqing.po.User;
import com.sanqing.service.UserService;
import com.sanqing.service.impl.UserServiceImpl;
import com.sanqing.service.CommodityClassService;
import com.sanqing.service.CommodityService;

public class GoIndex extends ActionSupport {
	private CommodityClassService commodityClassService;// ҵ���߼���
	private List<CommodityClass> commodityClasses;// ��Ʒ�����б�
	private CommodityService commodityService;// ҵ���߼���
	private List<Commodity> commodities;// ��Ʒ��Ϣ�б�
	private String username;//����Ա�û���
	private String password;//����Ա����
	private UserService userService;
	 
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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

	

	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}

	public void setCommodityClassService(
			CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}

	public List<CommodityClass> getCommodityClasses() {
		return commodityClasses;
	}

	public void setCommodityClasses(List<CommodityClass> commodityClasses) {
		this.commodityClasses = commodityClasses;
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public String execute() throws Exception {
		
		
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		System.out.println("-----------------------"+user.getUsername());
		
		//���request
		HttpServletRequest request = ServletActionContext.getRequest();
		if(("").equals(username) || ("").equals(password)) {

			//addFieldError("username", "�û�������Ϊ��");
//			request.setAttribute("url", "index.jsp");
//			request.setAttribute("info", "�˺����벻��Ϊ��");
			request.setAttribute("error", "�˺Ż����벻��Ϊ��");
//			return INPUT;
//			addActionError("�˺Ż������벻��Ϊ��");
			return this.INPUT;
			
		}else if(!userService.login(user)){
		
//			request.setAttribute("url", "index.jsp");
//			request.setAttribute("info", "�˺Ż����������");
			request.setAttribute("error", "�˺Ż���������");
			return ERROR;
//			addActionError("�˺Ż�����������");
//			return this.ERROR;
		
		}
		else {
		commodityClasses = commodityClassService.findAllCommodityClass();// ��ѯ���е���Ʒ����
		commodities = commodityService.queryByRegTime(9);//�������µľ�����Ʒ��¼
		return SUCCESS;
	}
	}
}
