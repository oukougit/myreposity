package com.sanqing.dao;

import java.util.List;

import com.sanqing.po.Student;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public interface StudentDAO {
	public Student findByStudentID(String studentID);//��ѯ����������ѧ��ID��ѯ
	public void updateStudent(Student student);//����ѧ����Ϣ
	public List<Student> findByStudentName(String studentName);//����ѧ����������ѧ��
	public List<Student> findByStudentClass(String sclass);//���ݰ༶����ѧ��
	public int findAllStudent();//���ݰ༶����ѧ��
	public List<Student> findStudentByPage(Page page);
	public void deleteStudent(int studentID);
	public Student findStudentByID(int studentID);
	public void insertStudent(Student student);
	
	
	
	
}
