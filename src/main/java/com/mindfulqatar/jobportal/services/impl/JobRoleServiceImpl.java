package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.JobRole;
import com.mindfulqatar.jobportal.repositories.JobRoleRepository;
import com.mindfulqatar.jobportal.services.JobRoleService;

@Service
public class JobRoleServiceImpl implements JobRoleService {

	@Autowired
	JobRoleRepository jobRoleRepository;

	@Override
	public JobRole save(JobRole jobRole) {
		return jobRoleRepository.save(jobRole);
	}

	@Override
	public List<JobRole> getAllJobRoles() {
		return jobRoleRepository.findAll();
	}
}
