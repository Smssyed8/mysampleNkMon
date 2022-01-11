package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.JobLevel;
import com.mindfulqatar.jobportal.repositories.JobLevelRepository;
import com.mindfulqatar.jobportal.services.JobLevelService;

@Service
public class JobLevelServiceImpl implements JobLevelService {

	@Autowired
	JobLevelRepository jobLevelRepository;

	@Override
	public JobLevel save(JobLevel jobLevel) {
		return jobLevelRepository.save(jobLevel);
	}

	@Override
	public List<JobLevel> getAllJobLevels() {
		return jobLevelRepository.findAll();
	}
}
