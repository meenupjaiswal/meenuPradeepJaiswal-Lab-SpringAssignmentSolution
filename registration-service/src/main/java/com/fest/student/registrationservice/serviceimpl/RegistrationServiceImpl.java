package com.fest.student.registrationservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fest.student.registrationservice.entity.Student;
import com.fest.student.registrationservice.repository.RegistrationRepository;
import com.fest.student.registrationservice.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public List<Student> getAllRegistrations() {
		return registrationRepository.findAll();
	}

	@Override
	public void saveRegistration(Student student) {
		registrationRepository.save(student);
	}
	
	@Override
	public void updateRegistration(int id, Student student) {
		Student savedStudent = getStudentById(id);
		if(savedStudent!=null) {
			savedStudent.setCountry(student.getCountry());
			savedStudent.setDepartment(student.getDepartment());
			savedStudent.setName(student.getName());
			registrationRepository.save(student);
		}
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> student = registrationRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		}
		return null;
	}

	@Override
	public void deleteRegistration(int id) {
		registrationRepository.deleteById(id);
	}

}
