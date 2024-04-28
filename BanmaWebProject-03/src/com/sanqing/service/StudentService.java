package com.sanqing.service;

import java.util.List;

import com.sanqing.po.Student;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public interface StudentService {
	//添加学生
	public void addStudent(Student student);
	//判断是否为合法学生，从而决定是否允许登录
	public boolean allowLogin(String studentID,String password,String studentName,Integer result,String sclass);
	//获得学生信息
	public Student getStudentInfo(String studentID);
	//设置学生成绩
	public void setStudentResult(String studentID,int result);
	//根据学生姓名查找学生
	public List<Student> getStudentByName(String studentName);
	//根据班级查找学生
	public List<Student> getStudentByClass(String sclass);
	//查询所有学生
	public PageResult queryStudentByPage(Page page);
	//删除学生
	public void deleteStudent(int studentID);
	//查看学生详细信息
	public Student showStudentParticular(int studentID);
	//更新学生信息
	public void updateStudent(Student student);
}
