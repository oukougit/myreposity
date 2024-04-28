package com.sanqing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Student;
import com.sanqing.po.Subject;
import com.sanqing.service.StudentService;
import com.sanqing.service.StudentServiceImpl;
import com.sanqing.service.SubjectService;
import com.sanqing.service.SubjectServiceImpl;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public class QueryStudentAction extends ActionSupport {
	private int currentPage;		//��ǰҳ
	private StudentService studentService = new StudentServiceImpl();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(5);//ÿҳ��ʾ5����¼
		page.setCurrentPage(currentPage);//���õ�ǰҳ
		PageResult pageResult = studentService.queryStudentByPage(page);
		List<Student> students = pageResult.getList();//��������¼
		page = pageResult.getPage();//��÷�ҳ��Ϣ
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students", students);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
