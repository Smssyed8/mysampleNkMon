package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.JobRole;

public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
	List<JobRole> findAll();
}
