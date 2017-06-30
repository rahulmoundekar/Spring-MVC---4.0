package com.dao;

import java.util.List;

import com.model.Student;

public interface ManipulationDao {

	public List<Student> getStudentList();

	public Student addStudent(Student student);

	public Student editStudent(int id);

	public void deleteStudent(int id);
}
