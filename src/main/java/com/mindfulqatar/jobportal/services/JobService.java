package com.mindfulqatar.jobportal.services;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import com.mindfulqatar.jobportal.entities.Employer;
import com.mindfulqatar.jobportal.entities.Job;
import com.mindfulqatar.jobportal.entities.JobLevel;
import com.mindfulqatar.jobportal.entities.JobRole;
import com.mindfulqatar.jobportal.entities.JobType;
import com.mindfulqatar.jobportal.entities.JobseekerJobMap;
import com.mindfulqatar.jobportal.entities.City;
import com.mindfulqatar.jobportal.entities.CompanyIndustry;
import com.mindfulqatar.jobportal.entities.CompanyType;
import com.mindfulqatar.jobportal.entities.Sector;

public interface JobService {
	List<Job> searchJobs(Job job);

	List<Job> getAllJobs();

	List<Job> getJobsByJobRoleId(Long jobRoleId);

	List<Job> getJobsByCompanyIndustryId(Long companyIndustryId);

	int getCountByJobRoleId(Long jobRoleId);

	int getCountByCompanyIndustryId(Long companyIndustryId);

	long getAllJobsCount();

	Job save(Job job);

	SortedMap<JobRole, Integer> getJobsWithJobRoleAndJobsCount();

	SortedMap<City, Integer> getJobsWithLocationAndJobsCount();

	SortedMap<Sector, Integer> getJobsWithSectorAndJobsCount(Long cityId);

	SortedMap<Employer, Integer> getJobsWithCompanyAndJobsCount();

	SortedMap<City, Integer> getJobsWithLocationAndJobsCountWithTitle(String jobTitle);

	SortedMap<JobRole, Integer> getJobsWithJobRoleAndJobsCountWithTitle(String jobTitle);

	SortedMap<CompanyIndustry, Integer> getJobsWithCompanyIndustryAndJobsCountWithTitle(String jobTitle);

	SortedMap<Sector, Integer> getJobsWithSectorAndJobsCountWithTitle(String jobTitle);

	SortedMap<Employer, Integer> getJobsWithCompanyAndJobsCountWithTitle(String jobTitle);

	SortedMap<Job, Long> getAvgSalaryForMostPopularJobs();

	SortedMap<Employer, Long> getAvgSalaryForCompanies();

	SortedMap<JobRole, Long> getAvgSalaryForJobRoles();

	SortedMap<City, Long> getAvgSalaryForLocations();

	int getCountForLastXDaysJobs(String jobTitle, int daysInterval);

	SortedMap<CompanyType, Integer> getJobsWithCompanyTypeAndJobsCountWithTitle(String jobTitle);

	SortedMap<JobType, Integer> getJobsWithJobTypeAndJobsCountWithTitle(String jobTitle);

	SortedMap<JobLevel, Integer> getJobsWithJobLevelAndJobsCountWithTitle(String jobTitle);

	Map<String, Integer> getJobsWithGenderAndJobsCountWithTitle(String jobTitle);

	List<Job> getJobsByEmployerId(Long employerId);

	List<Job> getTopNPopularJobs(int n);

	long getJobsAppliedCount();

	long getJobseekersAppliedCount();

	List<Long> getAllShortlistedCandidateIds(Long jobId);

	List<JobseekerJobMap> getAllShortlistedCandidates();

	List<Long> getAllShortlistedCandidatesIds();
}