package com.mindfulqatar.jobportal.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Job;
import com.mindfulqatar.jobportal.entities.Jobseeker;
import com.mindfulqatar.jobportal.entities.JobseekerJobMap;
import com.mindfulqatar.jobportal.repositories.JobseekerJobMapRepository;
import com.mindfulqatar.jobportal.services.JobseekerJobMapService;

@Service
public class JobseekerJobMapServiceImpl implements JobseekerJobMapService {

	@Autowired
	JobseekerJobMapRepository jobseekerJobMapRepository;

	@Override
	public JobseekerJobMap save(JobseekerJobMap jobseekerJobMap) {
		jobseekerJobMap.setCreatedOn(LocalDateTime.now());
		return jobseekerJobMapRepository.save(jobseekerJobMap);
	}

	@Override
	public List<JobseekerJobMap> getAllJobsByJobseekerId(Long jobseekerId) {
		return jobseekerJobMapRepository.findByJobseeker(new Jobseeker(jobseekerId));
	}

	@Override
	public List<Long> getAllJobIdsByJobseekerId(Long jobseekerId) {
		List<Long> jobIds = new ArrayList<Long>();
		List<JobseekerJobMap> listJjm = jobseekerJobMapRepository.findByJobseeker(new Jobseeker(jobseekerId));

		for (JobseekerJobMap jjm : listJjm) {
			jobIds.add(jjm.getJob().getId());
		}
		return jobIds;
	}

	@Override
	public List<JobseekerJobMap> getAllJobsByJobId(Long jobId) {
		return jobseekerJobMapRepository.findByJob(new Job(jobId));
	}

	@Override
	public Long countAllJobsByJobId(Long jobId) {
		return jobseekerJobMapRepository.countByJob(new Job(jobId));
	}

	@Override
	public JobseekerJobMap getByJobseekerAndJob(Jobseeker jobseeker, Job job) {
		return jobseekerJobMapRepository.findByJobseekerAndJob(jobseeker, job);
	}

	@SuppressWarnings("serial")
	@Override
	public List<JobseekerJobMap> searchJobseekerJobMap(JobseekerJobMap filter) {
		List<JobseekerJobMap> jobseekerJobMaps = jobseekerJobMapRepository
				.findAll(new Specification<JobseekerJobMap>() {

					@Override
					public Predicate toPredicate(Root<JobseekerJobMap> root, CriteriaQuery<?> query,
							CriteriaBuilder cb) {

						List<Predicate> predicates = new ArrayList<>();

						// If id is specified in filter, add equal where clause
						if (filter.getId() != null) {
							predicates.add(cb.equal(root.get("id"), filter.getId()));
						}

						// If job is specified in filter, add equal where clause
						if (filter.getJob() != null) {
							predicates.add(root.get("job").get("id").in(filter.getJob().getId()));
						}

						// If jobseeker is specified in filter, add equal where clause
						if (filter.getJobseeker() != null) {
							predicates.add(root.get("jobseeker").get("id").in(filter.getJobseeker().getId()));
						}

						// If shortlisted is specified in filter, add equal where clause
						if (filter.isShortlisted()) {
							predicates.add(cb.equal(root.get("shortlisted"), filter.isShortlisted()));
						}

						return cb.and(predicates.toArray(new Predicate[0]));
					}
				});
		return jobseekerJobMaps;
	}
}
