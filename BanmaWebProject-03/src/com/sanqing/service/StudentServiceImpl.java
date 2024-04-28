package com.sanqing.service;

import java.util.List;

import com.sanqing.dao.StudentDAO;
import com.sanqing.dao.StudentDAOImpl;
import com.sanqing.po.Student;

import com.sanqing.util.Page;
import com.sanqing.util.PageResult;
import com.sanqing.util.PageUtil;

public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO = new StudentDAOImpl();
	
	public boolean allowLogin(String studentID,String password,String studentName,Integer result,String sclass) {
		
		Student student = studentDAO.findByStudentID(studentID);
		if(student == null) {//�ж��Ƿ���ڸ�ID��ѧ��
			return false;
		}else {
			if(password.equals(student.getPassword())) {//�ж������Ƿ���ͬ
				return true;
			}else{
				return false;
			}
			
		}
	}

	public Student getStudentInfo(String studentID) {
		return studentDAO.findByStudentID(studentID);
	}

	public void setStudentResult(String studentID, int result) {
		Student student = studentDAO.findByStudentID(studentID);//����ID���ҵ���ѧ��
		student.setResult(result);//������ɼ�
		studentDAO.updateStudent(student);//����ѧ����Ϣ
	}

	public List<Student> getStudentByName(String studentName) {
		return studentDAO.findByStudentName(studentName);
	}

	public List<Student> getStudentByClass(String sclass) {
		return studentDAO.findByStudentClass(sclass);
	}

	public PageResult queryStudentByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(),
				studentDAO.findAllStudent(),page.getCurrentPage());//�����ܼ�¼��������ҳ��Ϣ
		List<Student> list = studentDAO.findStudentByPage(page);//ͨ����ҳ��Ϣȡ������
		PageResult result = new PageResult(page,list);//��װ��ҳ��Ϣ�ͼ�¼��Ϣ�����ظ����ô�
		return result;
	}

	public void deleteStudent(int studentID) {
		studentDAO.deleteStudent(studentID);
	
	}

	public Student showStudentParticular(int studentID) {
		return studentDAO.findStudentByID(studentID);
	}

	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
		
	}

	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
		
	}
	
	
}
