package com.mindfulqatar.jobportal.mapper;

import com.mindfulqatar.jobportal.dto.SearchJobseekerJobMapDTO;
import com.mindfulqatar.jobportal.entities.Job;
import com.mindfulqatar.jobportal.entities.Jobseeker;
import com.mindfulqatar.jobportal.entities.JobseekerJobMap;

public class JobseekerJobMapMapper {

	public static JobseekerJobMap toJobseekerJobMap(SearchJobseekerJobMapDTO jobseekerJobMapDTO) {
		JobseekerJobMap jobseekerJobMap = new JobseekerJobMap();

		if (jobseekerJobMapDTO.getId() != null) {
			jobseekerJobMap.setId(jobseekerJobMapDTO.getId());
		}

		if (jobseekerJobMapDTO.getShortlisted() != null && jobseekerJobMapDTO.getShortlisted()) {
			jobseekerJobMap.setShortlisted(jobseekerJobMapDTO.getShortlisted());
			;
		}

		if (jobseekerJobMapDTO.getJobId() != null) {
			jobseekerJobMap.setJob(new Job(jobseekerJobMapDTO.getJobId()));
		}

		if (jobseekerJobMapDTO.getJobseekerId() != null) {
			jobseekerJobMap.setJobseeker(new Jobseeker(jobseekerJobMapDTO.getJobseekerId()));
		}

		return jobseekerJobMap;
	}
}
