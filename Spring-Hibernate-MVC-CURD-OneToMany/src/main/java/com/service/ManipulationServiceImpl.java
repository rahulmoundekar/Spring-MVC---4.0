package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ManipulationDao;
import com.model.Student;

public class ManipulationServiceImpl implements ManipulationService {

	@Autowired
	ManipulationDao manipulationDao;

	public List<Student> getStudentList() {
		return manipulationDao.getStudentList();
	}

	public Student addStudent(Student student) {
		return manipulationDao.addStudent(student);
	}

	public Student editStudent(int id) {
		return manipulationDao.editStudent(id);
	}

	public void deleteStudent(int id) {
		manipulationDao.deleteStudent(id);
	}

}
