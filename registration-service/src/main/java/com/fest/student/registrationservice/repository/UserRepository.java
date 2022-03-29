package com.fest.student.registrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fest.student.registrationservice.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer>{
	
	AppUser findByUserName(String name);

}
