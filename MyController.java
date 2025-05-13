package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.student.entity.Student;
import com.student.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	MyService myservice;
	
//	************************************************************************
	
//	******************************Display All Student***********************
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		model.addAttribute("students",myservice.getAllStudents());
		return "students";
	}
//	******************************Create Form to take Record****************
	@GetMapping("/students/new")
	public String createform(Model model) {
		Student student=new Student();  // this object is used to hold form data
		model.addAttribute("students",student);
		return "createform";
	}
		
//	******************************Insert Form Data in Databases*************
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
	    myservice.saveStudent(student);
	    return "redirect:/students"; // Correct redirect syntax
	}

//	******************************create update form***************************
	
	@GetMapping("students/update/{id}")
	public String updatestudentById(@PathVariable int id,Model model) {
		model.addAttribute("student",myservice.getById(id));
		return "createditform";
	}
	
//	******************************Update existing data and save in db *********
	@PostMapping("/students/update/{id}")
	public String updateStudent( @PathVariable int id,@ModelAttribute("student") Student student) {
		Student existstudentdata=myservice.getById(id); 
		existstudentdata.setFirstname(student.getFirstname());
		existstudentdata.setLastname(student.getLastname());
		existstudentdata.setEmail(student.getEmail());
		
		myservice.saveStudent( existstudentdata);
		
		return "redirect:/students";
	}
//	*******************************Delete student by id************************
	@GetMapping("/students/delete/{id}")
	public String deletestudent(@PathVariable int id) {
		myservice.deleteById(id);
		return"redirect:/students";
	}
	
	
}			
