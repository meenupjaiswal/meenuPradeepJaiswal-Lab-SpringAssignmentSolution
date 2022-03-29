package com.fest.student.registrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fest.student.registrationservice.entity.Student;

@Repository
public interface RegistrationRepository extends JpaRepository<Student, Integer> {

}
