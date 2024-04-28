package com.sanqing.service;

import java.util.List;

import com.sanqing.po.Student;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public interface StudentService {
	//���ѧ��
	public void addStudent(Student student);
	//�ж��Ƿ�Ϊ�Ϸ�ѧ�����Ӷ������Ƿ������¼
	public boolean allowLogin(String studentID,String password,String studentName,Integer result,String sclass);
	//���ѧ����Ϣ
	public Student getStudentInfo(String studentID);
	//����ѧ���ɼ�
	public void setStudentResult(String studentID,int result);
	//����ѧ����������ѧ��
	public List<Student> getStudentByName(String studentName);
	//���ݰ༶����ѧ��
	public List<Student> getStudentByClass(String sclass);
	//��ѯ����ѧ��
	public PageResult queryStudentByPage(Page page);
	//ɾ��ѧ��
	public void deleteStudent(int studentID);
	//�鿴ѧ����ϸ��Ϣ
	public Student showStudentParticular(int studentID);
	//����ѧ����Ϣ
	public void updateStudent(Student student);
}
