package com.mindfulqatar.jobportal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.mindfulqatar.jobportal.entities.Job;
import com.mindfulqatar.jobportal.entities.Jobseeker;
import com.mindfulqatar.jobportal.entities.JobseekerJobMap;

public interface JobseekerJobMapRepository
		extends JpaRepository<JobseekerJobMap, Long>, JpaSpecificationExecutor<JobseekerJobMap> {
	Optional<JobseekerJobMap> findById(Long id);

	List<JobseekerJobMap> findByJobseeker(Jobseeker jobseeker);

	List<JobseekerJobMap> findByJob(Job job);

	JobseekerJobMap findByJobseekerAndJob(Jobseeker jobseeker, Job job);

	Long countByJob(Job job);

	List<JobseekerJobMap> findByJobAndShortlistedTrue(Job job);

	List<JobseekerJobMap> findByShortlistedTrue();
}
