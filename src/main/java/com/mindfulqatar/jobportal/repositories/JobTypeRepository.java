package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.JobType;

public interface JobTypeRepository extends JpaRepository<JobType, Long> {
	List<JobType> findAll();
}
