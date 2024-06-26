package com.sanqing.dao;

import java.util.List;

import com.sanqing.po.Student;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public interface StudentDAO {
	public Student findByStudentID(String studentID);//查询方法，根据学生ID查询
	public void updateStudent(Student student);//更新学生信息
	public List<Student> findByStudentName(String studentName);//根据学生姓名查找学生
	public List<Student> findByStudentClass(String sclass);//根据班级查找学生
	public int findAllStudent();//根据班级查找学生
	public List<Student> findStudentByPage(Page page);
	public void deleteStudent(int studentID);
	public Student findStudentByID(int studentID);
	public void insertStudent(Student student);
	
	
	
	
}
