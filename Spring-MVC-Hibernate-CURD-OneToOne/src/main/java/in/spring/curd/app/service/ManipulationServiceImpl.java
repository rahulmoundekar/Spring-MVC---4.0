package in.spring.curd.app.service;

import in.spring.curd.app.bean.Student;
import in.spring.curd.app.dao.ManipulationDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
