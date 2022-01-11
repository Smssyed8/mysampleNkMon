package com.mindfulqatar.jobportal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mindfulqatar.jobportal.entities.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long>, JpaSpecificationExecutor<Employer> {
	Optional<Employer> findById(Long id);

	long count();

	Employer findByAccountId(Long accountId);
}
