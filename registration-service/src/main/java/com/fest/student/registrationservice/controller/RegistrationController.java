package com.fest.student.registrationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fest.student.registrationservice.entity.Student;
import com.fest.student.registrationservice.service.RegistrationService;

@RestController
@RequestMapping("/students")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/getAllRegistrations")
	public List<Student> getAllRegistrations() {
		return registrationService.getAllRegistrations();
	}
	
	@GetMapping("/register/{id}")
	public Student getStudent(@PathVariable int id) {
		return registrationService.getStudentById(id);
	}
	
	@PostMapping("/register")
	public void registerStudent(@RequestBody Student student) {
		registrationService.saveRegistration(student);
	}
	
	@PutMapping("/register/{id}")
	public void updateStudent(@PathVariable int id, @RequestBody Student student) {
		registrationService.updateRegistration(id, student);
	}

	@DeleteMapping("/register/{id}")
	public void deleteRegistration(@PathVariable int id) {
		registrationService.deleteRegistration(id);
	}
}
