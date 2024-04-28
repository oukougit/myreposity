package com.sanqing.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Student;
import com.sanqing.po.Subject;
import com.sanqing.util.Page;

public class StudentDAOImpl implements StudentDAO{
	public Student findByStudentID(String studentID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();//�ر�Session����
		return student;
	}

	public void updateStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.update(student);//����ѧ����Ϣ
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}

	public List<Student> findByStudentName(String studentName) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Student as stu where stu.studentName = ?");
		query.setString(0, studentName);
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return list;
	}

	public List<Student> findByStudentClass(String sclass) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Student as stu where stu.sclass = ?");
		query.setString(0, sclass);
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return list;
	}

	public int findAllStudent() {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Student");
		List list = query.list();					//��ѯ������浽list��
		int count = list.size();
		HibernateSessionFactory.closeSession();//�ر�Session����
		return count;
	}

	public List<Student> findStudentByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Student");
		query.setMaxResults(page.getEveryPage());//���ò�ѯ��¼��
		query.setFirstResult(page.getBeginIndex());//���ò�ѯ��¼��ʼλ��
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();//�ر�Session����
		return list;
	}

	public void deleteStudent(int studentID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Student student = (Student) session.get(Student.class, studentID);
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.delete(student);
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
		
	}

	public Student findStudentByID(int studentID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return student;
	}

	public void insertStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		//Student student = (Student) session.get(Student.class,student);
		Transaction transaction= null;
		try{
			transaction = session.beginTransaction();//��������
			session.save(student);
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
				
        
      
		HibernateSessionFactory.closeSession();		//�ر�Session����
	}

	
	
}
