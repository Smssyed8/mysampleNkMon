package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.EmployerContactUs;

public interface EmployerContactUsRepository extends JpaRepository<EmployerContactUs, Long> {
	List<EmployerContactUs> findAll();
}