package com.sanqing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.service.StudentService;
import com.sanqing.service.StudentServiceImpl;
import com.sanqing.service.SubjectService;
import com.sanqing.service.SubjectServiceImpl;

public class StudentDeleteAction extends ActionSupport{
	private int studentID;
	private StudentService studentService = new StudentServiceImpl();
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String execute() throws Exception {
		studentService.deleteStudent(studentID);
		return SUCCESS;
	}
}
