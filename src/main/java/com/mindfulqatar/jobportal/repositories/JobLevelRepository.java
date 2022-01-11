package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.JobLevel;

public interface JobLevelRepository extends JpaRepository<JobLevel, Long> {
	List<JobLevel> findAll();
}
