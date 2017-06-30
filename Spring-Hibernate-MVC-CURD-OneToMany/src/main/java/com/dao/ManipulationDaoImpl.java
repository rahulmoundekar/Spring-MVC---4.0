package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Student;

public class ManipulationDaoImpl implements ManipulationDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Student> getStudentList() {
		Session session = sessionFactory.openSession();
		List<Student> lst = session.createCriteria(Student.class).list();
		return lst;

	}

	public Student addStudent(Student student) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(student);
		session.beginTransaction().commit();
		return student;

	}

	public Student editStudent(int id) {
		Session session = sessionFactory.openSession();
		System.out.println("edit dao");
		Student student = (Student) session.load(Student.class, id);
		session.beginTransaction().commit();
		session.flush();
		return student;

	}

	public void deleteStudent(int id) {
		Session session = sessionFactory.openSession();
		Student student = (Student) session.load(Student.class, id);
		session.delete(student);
		session.beginTransaction().commit();
		session.flush();
	}

}
