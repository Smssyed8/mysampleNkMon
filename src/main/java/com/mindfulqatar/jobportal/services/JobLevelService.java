package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.JobLevel;

public interface JobLevelService {
	List<JobLevel> getAllJobLevels();

	JobLevel save(JobLevel jobLevel);
}