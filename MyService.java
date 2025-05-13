package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface MyService {
	
	public List<Student> getAllStudents();
	public String saveStudent(Student student);
	public Student getById(int id);
	public String deleteById(int id);

}