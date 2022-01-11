package com.mindfulqatar.jobportal.services.impl;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.CompanyIndustry;
import com.mindfulqatar.jobportal.entities.CompanyType;
import com.mindfulqatar.jobportal.entities.Employer;
import com.mindfulqatar.jobportal.entities.Job;
import com.mindfulqatar.jobportal.entities.JobLevel;
import com.mindfulqatar.jobportal.entities.JobRole;
import com.mindfulqatar.jobportal.entities.JobType;
import com.mindfulqatar.jobportal.entities.JobseekerJobMap;
import com.mindfulqatar.jobportal.entities.City;
import com.mindfulqatar.jobportal.entities.Sector;
import com.mindfulqatar.jobportal.repositories.EmployerRepository;
import com.mindfulqatar.jobportal.repositories.JobLevelRepository;
import com.mindfulqatar.jobportal.repositories.JobRepository;
import com.mindfulqatar.jobportal.repositories.JobRoleRepository;
import com.mindfulqatar.jobportal.repositories.JobTypeRepository;
import com.mindfulqatar.jobportal.repositories.JobseekerJobMapRepository;
import com.mindfulqatar.jobportal.repositories.CityRepository;
import com.mindfulqatar.jobportal.repositories.CompanyIndustryRepository;
import com.mindfulqatar.jobportal.repositories.CompanyTypeRepository;
import com.mindfulqatar.jobportal.repositories.SectorRepository;
import com.mindfulqatar.jobportal.services.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepository;

	@Autowired
	JobRoleRepository jobRoleRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	SectorRepository sectorRepository;

	@Autowired
	EmployerRepository employerRepository;

	@Autowired
	CompanyIndustryRepository companyIndustryRepository;

	@Autowired
	CompanyTypeRepository companyTypeRepository;

	@Autowired
	JobTypeRepository jobTypeRepository;

	@Autowired
	JobLevelRepository jobLevelRepository;

	@Autowired
	JobseekerJobMapRepository jobseekerJobMapRepository;

	@Override
	public Job save(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public List<Job> getJobsByJobRoleId(Long jobRoleId) {
		return jobRepository.findByJobRole(jobRoleId);
	}

	@Override
	public List<Job> getJobsByCompanyIndustryId(Long companyIndustryId) {
		return jobRepository.findByCompanyIndustry(companyIndustryId);
	}

	@Override
	public int getCountByJobRoleId(Long jobRoleId) {
		return jobRepository.countByJobRole(jobRoleId);
	}

	@Override
	public int getCountByCompanyIndustryId(Long companyIndustryId) {
		return jobRepository.countByCompanyIndustry(companyIndustryId);
	}

	@Override
	public SortedMap<JobRole, Integer> getJobsWithJobRoleAndJobsCount() {
		SortedMap<JobRole, Integer> jobRolesWithCount = new TreeMap<>();

		List<JobRole> jobRoles = jobRoleRepository.findAll();

		for (JobRole jr : jobRoles) {
			int jobCount = jobRepository.countByJobRole(jr.getId());
			if (jobCount > 0) {
				jobRolesWithCount.put(jr, jobCount);
			}
		}

		return jobRolesWithCount;
	}

	@Override
	public SortedMap<City, Integer> getJobsWithLocationAndJobsCount() {
		SortedMap<City, Integer> locationsWithJobsCount = new TreeMap<>();

		List<City> cities = cityRepository.findAll();

		for (City ljc : cities) {
			int jobCount = jobRepository.countByCity(ljc);
			if (jobCount > 0) {
				locationsWithJobsCount.put(ljc, jobCount);
			}
		}

		return locationsWithJobsCount;
	}

	@Override
	public SortedMap<Sector, Integer> getJobsWithSectorAndJobsCount(Long cityId) {
		SortedMap<Sector, Integer> jobsWithSectorAndJobsCount = new TreeMap<>();

		List<Sector> sectors = sectorRepository.findAll();
		int jobCount = 0;

		for (Sector sector : sectors) {
			List<CompanyIndustry> cis = new ArrayList<CompanyIndustry>();
			List<CompanyIndustry> companyIndustries = sector.getCompanyIndustries();
			for (CompanyIndustry ci : companyIndustries) {
				if (cityId == null) {
					jobCount = jobRepository.countByCompanyIndustry(ci.getId());
				} else {
					jobCount = jobRepository.countByCompanyIndustryAndCityId(ci.getId(), cityId);
				}

				if (jobCount > 0) {
					cis.add(ci);
					sector.setCompanyIndustries(cis);
					jobsWithSectorAndJobsCount.put(sector, jobCount);
				}
			}
		}
		return jobsWithSectorAndJobsCount;
	}

	@Override
	public SortedMap<Employer, Integer> getJobsWithCompanyAndJobsCount() {
		SortedMap<Employer, Integer> jobsWithCompanyAndJobsCount = new TreeMap<>();

		List<Employer> employers = employerRepository.findAll();

		for (Employer emp : employers) {
			int jobCount = jobRepository.countByEmployer(emp);
			if (jobCount > 0) {
				jobsWithCompanyAndJobsCount.put(emp, jobCount);
			}
		}
		return jobsWithCompanyAndJobsCount;
	}

	@Override
	public long getAllJobsCount() {
		return jobRepository.count();
	}

	@SuppressWarnings("serial")
	@Override
	public List<Job> searchJobs(Job filter) {
		List<Job> jobs = jobRepository.findAll(new Specification<Job>() {

			@Override
			public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				// If id is specified in filter, add equal where clause
				if (filter.getId() != null) {
					predicates.add(cb.equal(root.get("id"), filter.getId()));
				}

				// If employers is specified in filter, add equal where clause
				if (filter.getEmployers() != null && !filter.getEmployers().isEmpty()) {
					predicates.add(root.get("employer").get("id").in(filter.getEmployers()));
				}

				// If job title is specified in filter, add equal where clause
				if (filter.getJobTitle() != null) {
					predicates.add(cb.or(
							cb.like(cb.upper(root.get("jobTitle")), "%" + filter.getJobTitle().toUpperCase() + "%"),
							cb.like(cb.upper(root.get("description")), "%" + filter.getJobTitle().toUpperCase() + "%"),
							cb.like(cb.upper(root.get("skills")), "%" + filter.getJobTitle().toUpperCase() + "%")));
				}

				// If cityIds is specified in filter, add equal where clause
				if (filter.getCityIds() != null && !filter.getCityIds().isEmpty()) {
					predicates.add(root.get("city").in(filter.getCityIds()));
				}

				// If jobRoles is specified in filter, add equal where clause
				if (filter.getJobRoles() != null && !filter.getJobRoles().isEmpty()) {
					predicates.add(root.get("jobRole").in(filter.getJobRoles()));
				}

				// If companyIndustries is specified in filter, add equal where clause
				if (filter.getCompanyIndustries() != null && !filter.getCompanyIndustries().isEmpty()) {
					predicates.add(root.get("companyIndustry").in(filter.getCompanyIndustries()));
				}

				// If sectors is specified in filter, add equal where clause
				if (filter.getSectors() != null && !filter.getSectors().isEmpty()) {
					predicates.add(root.get("companyIndustry")
							.in(companyIndustryRepository.getCompanyIndustryIdsBySectorIds(filter.getSectors())));
				}

				// If company types is specified in filter, add equal where clause
				if (filter.getCompanyTypes() != null && !filter.getCompanyTypes().isEmpty()) {
					predicates.add(root.get("employer").get("companyType").in(filter.getCompanyTypes()));
				}

				// If daysInterval is specified in filter, add equal where clause
				if (filter.getDaysInterval() > 0) {
					LocalDateTime endDate = LocalDateTime.now();
					LocalDateTime startDate = endDate.minusDays(filter.getDaysInterval());

					predicates.add(cb.between(root.get("updatedOn"), startDate, endDate));
				}

				// If genders is specified in filter, add equal where clause
				if (filter.getGenders() != null && !filter.getGenders().isEmpty()) {
					predicates.add(root.get("requiredGender").in(filter.getGenders()));
				}

				// If monthly salary is specified in filter, add equal where clause
				if (filter.getMonthlySalary() != null && filter.getMonthlySalary() > 0) {
					predicates.add(cb.or(cb.greaterThanOrEqualTo(root.get("monthlySalary"), filter.getMonthlySalary()),
							cb.greaterThanOrEqualTo(root.get("minSalary"), filter.getMonthlySalary())));
				}

				// If jobLevels is specified in filter, add equal where clause
				if (filter.getJobLevels() != null && !filter.getJobLevels().isEmpty()) {
					predicates.add(root.get("jobLevel").in(filter.getJobLevels()));
				}

				// If jobTypes is specified in filter, add equal where clause
				if (filter.getJobTypes() != null && !filter.getJobTypes().isEmpty()) {
					predicates.add(root.get("jobType").in(filter.getJobTypes()));
				}

				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		return jobs;
	}

	@Override
	public SortedMap<City, Integer> getJobsWithLocationAndJobsCountWithTitle(String jobTitle) {
		SortedMap<City, Integer> locationsWithJobsCountWithTitle = new TreeMap<>();

		List<City> cities = cityRepository.findAll();

		for (City ljc : cities) {
			int jobCount = jobRepository.countByCityAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(ljc.getId(),
					"%" + jobTitle + "%");
			if (jobCount > 0) {
				locationsWithJobsCountWithTitle.put(ljc, jobCount);
			}
		}

		return locationsWithJobsCountWithTitle;
	}

	@Override
	public SortedMap<JobRole, Integer> getJobsWithJobRoleAndJobsCountWithTitle(String jobTitle) {
		SortedMap<JobRole, Integer> jobRolesWithJobsCountWithTitle = new TreeMap<>();

		List<JobRole> jobRoles = jobRoleRepository.findAll();

		for (JobRole jobRole : jobRoles) {
			int jobCount = jobRepository.countByJobRoleAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(
					jobRole.getId(), "%" + jobTitle + "%");
			if (jobCount > 0) {
				jobRolesWithJobsCountWithTitle.put(jobRole, jobCount);
			}
		}

		return jobRolesWithJobsCountWithTitle;
	}

	@Override
	public SortedMap<CompanyIndustry, Integer> getJobsWithCompanyIndustryAndJobsCountWithTitle(String jobTitle) {
		SortedMap<CompanyIndustry, Integer> companyIndustriesWithJobsCountWithTitle = new TreeMap<>();

		List<CompanyIndustry> companyIndustries = companyIndustryRepository.findAll();

		for (CompanyIndustry companyIndustry : companyIndustries) {
			int jobCount = jobRepository.countByCompanyIndustryAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(
					companyIndustry.getId(), "%" + jobTitle + "%");
			if (jobCount > 0) {
				companyIndustriesWithJobsCountWithTitle.put(companyIndustry, jobCount);
			}
		}

		return companyIndustriesWithJobsCountWithTitle;
	}

	@Override
	public SortedMap<Sector, Integer> getJobsWithSectorAndJobsCountWithTitle(String jobTitle) {
		SortedMap<Sector, Integer> sectorsWithJobsCountWithTitle = new TreeMap<>();

		List<Sector> sectors = sectorRepository.findAll();

		for (Sector sector : sectors) {
			int jobCount = jobRepository.countBySectorAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(
					sector.getId(), "%" + jobTitle + "%");
			if (jobCount > 0) {
				sectorsWithJobsCountWithTitle.put(sector, jobCount);
			}
		}

		return sectorsWithJobsCountWithTitle;
	}

	@Override
	public int getCountForLastXDaysJobs(String jobTitle, int daysInterval) {

		LocalDateTime endDate = LocalDateTime.now();
		LocalDateTime startDate = endDate.minusDays(daysInterval);

		return jobRepository.countJobsBetweenDatesAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(startDate,
				endDate, "%" + jobTitle + "%");
	}

	@Override
	public SortedMap<Employer, Integer> getJobsWithCompanyAndJobsCountWithTitle(String jobTitle) {
		SortedMap<Employer, Integer> jobsWithCompanyAndJobsCountWithTitle = new TreeMap<>();

		List<Employer> employers = employerRepository.findAll();
		for (Employer emp : employers) {
			int jobCount = jobRepository.countByEmployerAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(
					emp.getId(), "%" + jobTitle + "%");
			if (jobCount > 0) {
				jobsWithCompanyAndJobsCountWithTitle.put(emp, jobCount);
			}
		}
		return jobsWithCompanyAndJobsCountWithTitle;
	}

	@Override
	public SortedMap<Job, Long> getAvgSalaryForMostPopularJobs() {
		SortedMap<Job, Long> avgSalaryForMostPopularJobs = new TreeMap<>();

		// Here we need to find 5 most popular jobs first based on most applied jobs
		List<BigInteger> jobIds = jobRepository.getTopNPopularJobIds(5);

		List<Job> jobs = getJobsBasedOnJobIds(jobIds);

		for (Job job : jobs) {
			Long avgSalary = jobRepository.getAVGMonthlySalaryByJobTitle(job.getJobTitle());
			if (avgSalary != null) {
				avgSalaryForMostPopularJobs.put(job, avgSalary);
			}
		}
		return avgSalaryForMostPopularJobs;
	}

	@Override
	public SortedMap<Employer, Long> getAvgSalaryForCompanies() {
		SortedMap<Employer, Long> avgSalaryForCompanies = new TreeMap<>();

		List<Employer> employers = employerRepository.findAll();
		for (Employer emp : employers) {
			Long avgSalary = jobRepository.getAVGMonthlySalaryByEmployer(emp.getId());
			if (avgSalary != null) {
				avgSalaryForCompanies.put(emp, avgSalary);
			}
		}
		return avgSalaryForCompanies;
	}

	@Override
	public SortedMap<JobRole, Long> getAvgSalaryForJobRoles() {
		SortedMap<JobRole, Long> avgSalaryForJobRoles = new TreeMap<>();

		List<JobRole> jobRoles = jobRoleRepository.findAll();

		for (JobRole jobRole : jobRoles) {
			Long avgSalary = jobRepository.getAVGMonthlySalaryByJobRole(jobRole.getId());
			if (avgSalary != null) {
				avgSalaryForJobRoles.put(jobRole, avgSalary);
			}
		}
		return avgSalaryForJobRoles;
	}

	@Override
	public SortedMap<City, Long> getAvgSalaryForLocations() {
		SortedMap<City, Long> avgSalaryForLocations = new TreeMap<>();

		List<City> cities = cityRepository.findAll();

		for (City city : cities) {
			Long avgSalary = jobRepository.getAVGMonthlySalaryByLocation(city.getId());
			if (avgSalary != null) {
				avgSalaryForLocations.put(city, avgSalary);
			}
		}
		return avgSalaryForLocations;
	}

	@Override
	public List<Job> getTopNPopularJobs(int n) {
		List<BigInteger> jobIds = jobRepository.getTopNPopularJobIds(n);
		List<Job> jobs = getJobsBasedOnJobIds(jobIds);

		return jobs;
	}

	private List<Job> getJobsBasedOnJobIds(List<BigInteger> jobIds) {
		List<Job> jobs = new ArrayList<Job>();

		for (BigInteger jobId : jobIds) {
			jobs.add(jobRepository.findById(jobId.longValue()).get());
		}
		return jobs;
	}

	@Override
	public SortedMap<CompanyType, Integer> getJobsWithCompanyTypeAndJobsCountWithTitle(String jobTitle) {
		SortedMap<CompanyType, Integer> companyTypesWithJobsCountWithTitle = new TreeMap<>();

		List<CompanyType> companyTypes = companyTypeRepository.findAll();

		for (CompanyType companyType : companyTypes) {
			int jobCount = jobRepository.countByCompanyTypeAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(
					companyType.getId(), "%" + jobTitle + "%");
			if (jobCount > 0) {
				companyTypesWithJobsCountWithTitle.put(companyType, jobCount);
			}
		}

		return companyTypesWithJobsCountWithTitle;
	}

	@Override
	public SortedMap<JobType, Integer> getJobsWithJobTypeAndJobsCountWithTitle(String jobTitle) {
		SortedMap<JobType, Integer> jobTypesWithJobsCountWithTitle = new TreeMap<>();

		List<JobType> jobTypes = jobTypeRepository.findAll();

		for (JobType jobType : jobTypes) {
			int jobCount = jobRepository.countByJobTypeAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(
					jobType.getId(), "%" + jobTitle + "%");
			if (jobCount > 0) {
				jobTypesWithJobsCountWithTitle.put(jobType, jobCount);
			}
		}

		return jobTypesWithJobsCountWithTitle;
	}

	@Override
	public SortedMap<JobLevel, Integer> getJobsWithJobLevelAndJobsCountWithTitle(String jobTitle) {
		SortedMap<JobLevel, Integer> jobLevelsWithJobsCountWithTitle = new TreeMap<>();

		List<JobLevel> jobLevels = jobLevelRepository.findAll();

		for (JobLevel joblevel : jobLevels) {
			int jobCount = jobRepository.countByJobTypeAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(
					joblevel.getId(), "%" + jobTitle + "%");
			if (jobCount > 0) {
				jobLevelsWithJobsCountWithTitle.put(joblevel, jobCount);
			}
		}

		return jobLevelsWithJobsCountWithTitle;
	}

	@Override
	public Map<String, Integer> getJobsWithGenderAndJobsCountWithTitle(String jobTitle) {
		Map<String, Integer> gendersWithJobsCountWithTitle = new LinkedHashMap<>();

		int jobCount = jobRepository.countByGenderAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike("m",
				"%" + jobTitle + "%");
		if (jobCount > 0) {
			gendersWithJobsCountWithTitle.put("m", jobCount);
		}

		jobCount = jobRepository.countByGenderAndJobTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike("f",
				"%" + jobTitle + "%");

		if (jobCount > 0) {
			gendersWithJobsCountWithTitle.put("f", jobCount);
		}

		return gendersWithJobsCountWithTitle;
	}

	@Override
	public long getJobsAppliedCount() {
		return jobRepository.countJobsApplied();
	}

	@Override
	public long getJobseekersAppliedCount() {
		return jobRepository.countJobseekersApplied();
	}

	@Override
	public List<Job> getJobsByEmployerId(Long employerId) {
		return jobRepository.findByEmployer(new Employer(employerId));
	}

	@Override
	public List<Long> getAllShortlistedCandidateIds(Long jobId) {
		List<Long> jobseekerIds = new ArrayList<Long>();
		List<JobseekerJobMap> listJjm = jobseekerJobMapRepository.findByJobAndShortlistedTrue(new Job(jobId));

		for (JobseekerJobMap jjm : listJjm) {
			jobseekerIds.add(jjm.getJobseeker().getId());
		}
		return jobseekerIds;
	}

	@Override
	public List<JobseekerJobMap> getAllShortlistedCandidates() {
		return jobseekerJobMapRepository.findByShortlistedTrue();
	}

	@Override
	public List<Long> getAllShortlistedCandidatesIds() {
		List<Long> jobseekerIds = new ArrayList<Long>();
		List<JobseekerJobMap> listJjm = jobseekerJobMapRepository.findByShortlistedTrue();

		for (JobseekerJobMap jjm : listJjm) {
			jobseekerIds.add(jjm.getJobseeker().getId());
		}
		return jobseekerIds;
	}
}
