package in.spring.curd.app.service;

import in.spring.curd.app.bean.Student;

import java.util.List;

public interface ManipulationService {
	public List<Student> getStudentList();

	public Student addStudent(Student student);

	public Student editStudent(int id);

	public void deleteStudent(int id);

}
