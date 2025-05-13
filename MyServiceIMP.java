package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.MyRepository;

@Service
public class MyServiceIMP implements MyService{

	@Autowired
	MyRepository myrepository;
	
//	******************************************************
	
	public List<Student> getAllStudents() {
		List<Student> list = myrepository.findAll();
		return list;
	}
//	******************************************************

	@Override
	public String saveStudent(Student student) {
		myrepository.save(student);
		return "redirect/students";
	}
//	******************************************************
	@Override
	public Student getById(int id) {
		return myrepository.findById(id).get();
	}

	
//	******************************************************
	@Override
	public String deleteById(int id) {
		myrepository.deleteById(id);
		return "redirect:/students";
	}
	
	

}
