package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.JobType;

public interface JobTypeService {
	List<JobType> getAllJobTypes();

	JobType save(JobType jobType);
}