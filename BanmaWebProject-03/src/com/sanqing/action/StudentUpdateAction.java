package com.sanqing.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Student;
import com.sanqing.service.StudentService;
import com.sanqing.service.StudentServiceImpl;

public class StudentUpdateAction extends ActionSupport{
	private String studentID;
	private String password;
	private String studentName;
	private Integer result;
	private String sclass;
	public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Integer getResult() {
		return result;
	}


	public void setResult(Integer result) {
		this.result = result;
	}


	public String getSclass() {
		return sclass;
	}


	public void setSclass(String sclass) {
		this.sclass = sclass;
	}


	
	private StudentService studentService = new StudentServiceImpl();
	
	
	public String execute() throws Exception {
		Student student = new Student();
		student.setStudentID(studentID);
		student.setStudentName(studentName);
		student.setPassword(password);
		student.setResult(result);
		student.setSclass(sclass);
		
		studentService.updateStudent(student);//更新
		ServletActionContext.getRequest().setAttribute("student", student);
		this.addActionMessage("更新成功!");
		return SUCCESS;
	}
}
