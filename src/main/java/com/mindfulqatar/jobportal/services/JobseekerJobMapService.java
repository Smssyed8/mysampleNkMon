package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.Job;
import com.mindfulqatar.jobportal.entities.Jobseeker;
import com.mindfulqatar.jobportal.entities.JobseekerJobMap;

public interface JobseekerJobMapService {
	List<JobseekerJobMap> getAllJobsByJobseekerId(Long jobseekerId);

	List<Long> getAllJobIdsByJobseekerId(Long jobseekerId);

	JobseekerJobMap save(JobseekerJobMap jobseekerJobMap);

	List<JobseekerJobMap> getAllJobsByJobId(Long jobId);

	Long countAllJobsByJobId(Long jobId);

	JobseekerJobMap getByJobseekerAndJob(Jobseeker jobseeker, Job job);

	List<JobseekerJobMap> searchJobseekerJobMap(JobseekerJobMap jobseekerJobMap);
}