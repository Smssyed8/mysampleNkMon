package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.CompanyType;

public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
	List<CompanyType> findAll();
}