package in.spring.curd.app.dao;

import in.spring.curd.app.bean.Student;

import java.util.List;

public interface ManipulationDao {

	public List<Student> getStudentList();

	public Student addStudent(Student student);

	public Student editStudent(int id);

	public void deleteStudent(int id);
}
