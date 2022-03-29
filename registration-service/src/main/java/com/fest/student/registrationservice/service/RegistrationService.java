package com.fest.student.registrationservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fest.student.registrationservice.entity.Student;


@Service
public interface RegistrationService {

	List<Student> getAllRegistrations();

	void saveRegistration(Student student);
	
	void updateRegistration(int id, Student student);

	Student getStudentById(int id);

	void deleteRegistration(int id);

}