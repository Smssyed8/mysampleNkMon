package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.dto.SearchJobseekersDTO;
import com.mindfulqatar.jobportal.entities.Jobseeker;

public interface JobseekerService {
	Jobseeker getJobseekerByEmail(String email);

	Jobseeker save(Jobseeker jobseeker);

	long countJobseekers();

	void deleteJobseeker(Long id);

	List<Jobseeker> searchJobseekers(Jobseeker jobseeker);

	List<Jobseeker> getAllJobseekers();

	Boolean isValidJobseeker(Long accountId);

	List<Jobseeker> searchJobseekersWithExtraFilters(Jobseeker jobseeker, SearchJobseekersDTO searchJobseekersDTO);
}