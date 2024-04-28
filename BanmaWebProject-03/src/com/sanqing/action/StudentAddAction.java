package com.sanqing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Student;
import com.sanqing.po.Subject;
import com.sanqing.service.StudentService;
import com.sanqing.service.StudentServiceImpl;
import com.sanqing.service.SubjectService;
import com.sanqing.service.SubjectServiceImpl;

//��Action�����������������������ҵ���߼����SubjectService������������
public class StudentAddAction extends ActionSupport{
	private String studentID;
	private String password;
	private String studentName;
	private Integer result;
	private String sclass;
	private StudentService studentService = new StudentServiceImpl();
	
	
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

	public String execute() throws Exception {
		Student student = new Student();
		student.setStudentID(studentID);
		student.setResult(result);
		student.setPassword(password);
		student.setStudentName(studentName);
		student.setSclass(sclass);
		
		if(!studentService.allowLogin(studentID,password,studentName, result,sclass)) {
			studentService.addStudent(student);
			return SUCCESS;
		}else {
			this.addActionError("��ѧ���Ѿ���ӹ��ˣ��벻Ҫ�ظ����!");
			return INPUT;
		}
	}
}
