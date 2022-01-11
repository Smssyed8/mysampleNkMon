package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.JobType;
import com.mindfulqatar.jobportal.repositories.JobTypeRepository;
import com.mindfulqatar.jobportal.services.JobTypeService;

@Service
public class JobTypeServiceImpl implements JobTypeService {

	@Autowired
	JobTypeRepository jobTypeRepository;

	@Override
	public JobType save(JobType jobType) {
		return jobTypeRepository.save(jobType);
	}

	@Override
	public List<JobType> getAllJobTypes() {
		return jobTypeRepository.findAll();
	}
}
