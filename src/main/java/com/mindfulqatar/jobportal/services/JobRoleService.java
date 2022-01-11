package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.JobRole;

public interface JobRoleService {
	List<JobRole> getAllJobRoles();

	JobRole save(JobRole jobRole);
}