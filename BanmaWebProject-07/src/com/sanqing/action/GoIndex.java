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
	private CommodityClassService commodityClassService;// 业务逻辑层
	private List<CommodityClass> commodityClasses;// 商品种类列表
	private CommodityService commodityService;// 业务逻辑层
	private List<Commodity> commodities;// 商品信息列表
	private String username;//管理员用户名
	private String password;//管理员密码
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
		
		//获得request
		HttpServletRequest request = ServletActionContext.getRequest();
		if(("").equals(username) || ("").equals(password)) {

			//addFieldError("username", "用户名不能为空");
//			request.setAttribute("url", "index.jsp");
//			request.setAttribute("info", "账号密码不能为空");
			request.setAttribute("error", "账号或密码不能为空");
//			return INPUT;
//			addActionError("账号或者密码不能为空");
			return this.INPUT;
			
		}else if(!userService.login(user)){
		
//			request.setAttribute("url", "index.jsp");
//			request.setAttribute("info", "账号或者密码错误");
			request.setAttribute("error", "账号或密码有误");
			return ERROR;
//			addActionError("账号或者密码有误");
//			return this.ERROR;
		
		}
		else {
		commodityClasses = commodityClassService.findAllCommodityClass();// 查询所有的商品种类
		commodities = commodityService.queryByRegTime(9);//查找最新的九条商品记录
		return SUCCESS;
	}
	}
}
