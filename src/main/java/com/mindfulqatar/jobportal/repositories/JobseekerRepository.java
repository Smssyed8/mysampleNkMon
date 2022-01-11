package com.mindfulqatar.jobportal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.Jobseeker;

public interface JobseekerRepository extends JpaRepository<Jobseeker, Long>, JpaSpecificationExecutor<Jobseeker> {
	Optional<Jobseeker> findById(Long id);

	Jobseeker findByAccount(Account account);
}
