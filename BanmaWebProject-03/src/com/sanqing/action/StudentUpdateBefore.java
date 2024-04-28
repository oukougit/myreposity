package com.sanqing.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Student;
import com.sanqing.po.Subject;
import com.sanqing.service.StudentService;
import com.sanqing.service.StudentServiceImpl;
import com.sanqing.service.SubjectService;
import com.sanqing.service.SubjectServiceImpl;

/*
 * 获得更新试题前的试题
 */
public class StudentUpdateBefore extends ActionSupport {
	private int studentID;
	private StudentService studentService = new StudentServiceImpl();
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String execute() throws Exception {
		Student student = studentService.showStudentParticular(studentID);
		ServletActionContext.getRequest().setAttribute("student", student);
		return SUCCESS;
	}
}
