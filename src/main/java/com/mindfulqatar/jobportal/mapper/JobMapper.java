package com.mindfulqatar.jobportal.mapper;

import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.City;
import com.mindfulqatar.jobportal.entities.Employer;
import com.mindfulqatar.jobportal.entities.Job;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.mindfulqatar.jobportal.dto.JobPostDTO;
import com.mindfulqatar.jobportal.dto.SearchJobsDTO;

public class JobMapper {

	public static Job toJob(SearchJobsDTO jobDTO) {
		Job job = new Job();

		if (jobDTO.getId() != null) {
			job.setId(jobDTO.getId());
		}

		if (jobDTO.getEmployers() != null && !jobDTO.getEmployers().isEmpty()) {
			job.setEmployers(jobDTO.getEmployers());
		}

		if (jobDTO.getJobTitle() != null && !jobDTO.getJobTitle().isEmpty()) {
			job.setJobTitle(jobDTO.getJobTitle());
		}

		if (jobDTO.getJobLevels() != null && !jobDTO.getJobLevels().isEmpty()) {
			job.setJobLevels(jobDTO.getJobLevels());
		}

		if (jobDTO.getTypeOfWork() != null && !jobDTO.getTypeOfWork().isEmpty()) {
			job.setTypeOfWork(jobDTO.getTypeOfWork());
		}

		if (jobDTO.getMonthlySalary() != null) {
			job.setMonthlySalary(jobDTO.getMonthlySalary());
		}

		if (jobDTO.getNoticePeriod() != 0) {
			job.setNoticePeriod(jobDTO.getNoticePeriod());
		}

		if (jobDTO.getYearsOfExperience() != 0) {
			job.setYearsOfExperience(jobDTO.getYearsOfExperience());
		}

		if (jobDTO.getSkills() != null && !jobDTO.getSkills().isEmpty()) {
			job.setSkills(jobDTO.getSkills());
		}

		if (jobDTO.getLastDateForApplication() != null) {
			job.setLastDateForApplication(jobDTO.getLastDateForApplication());
		}

		if (jobDTO.getMinSalary() != null) {
			job.setMinSalary(jobDTO.getMinSalary());
		}

		if (jobDTO.getMaxSalary() != null) {
			job.setMaxSalary(jobDTO.getMaxSalary());
		}

		if (jobDTO.getQualification() != null && !jobDTO.getQualification().isEmpty()) {
			job.setQualification(jobDTO.getQualification());
		}

		if (jobDTO.getCreatedOn() != null) {
			job.setCreatedOn(jobDTO.getCreatedOn());
		}

		if (jobDTO.getUpdatedOn() != null) {
			job.setUpdatedOn(jobDTO.getUpdatedOn());
		}

		if (jobDTO.getUpdatedBy() != null) {
			job.setUpdatedBy(jobDTO.getUpdatedBy());
		}

		if (jobDTO.getCityIds() != null && !jobDTO.getCityIds().isEmpty()) {
			job.setCityIds(jobDTO.getCityIds());
		}

		if (jobDTO.getJobRoles() != null && !jobDTO.getJobRoles().isEmpty()) {
			job.setJobRoles(jobDTO.getJobRoles());
		}

		if (jobDTO.getCompanyIndustries() != null && !jobDTO.getCompanyIndustries().isEmpty()) {
			job.setCompanyIndustries(jobDTO.getCompanyIndustries());
		}

		if (jobDTO.getCompanySectors() != null && !jobDTO.getCompanySectors().isEmpty()) {
			job.setSectors(jobDTO.getCompanySectors());
		}

		if (jobDTO.getCompanyTypes() != null && !jobDTO.getCompanyTypes().isEmpty()) {
			job.setCompanyTypes(jobDTO.getCompanyTypes());
		}

		if (jobDTO.getGenders() != null && !jobDTO.getGenders().isEmpty()) {
			job.setGenders(jobDTO.getGenders());
		}

		if (jobDTO.getJobTypes() != null && !jobDTO.getJobTypes().isEmpty()) {
			job.setJobTypes(jobDTO.getJobTypes());
		}

		job.setDaysInterval(jobDTO.getDaysInterval());

		return job;
	}

	public static Job toJob(Account currentLoggedInUser, JobPostDTO jobPostDTO) {
		Job job = new Job();

		job.setEmployer(new Employer(jobPostDTO.getEmployerId()));
		job.setJobTitle(jobPostDTO.getJobTitle());
		job.setJobRole(jobPostDTO.getJobRole());
		job.setCity(new City(jobPostDTO.getCity()));
		job.setJobLevel(jobPostDTO.getJobLevel());
		job.setJobType(jobPostDTO.getJobType());
		job.setCompanyIndustry(jobPostDTO.getCompanyIndustry());
		job.setTypeOfWork(jobPostDTO.getTypeOfWork());
		job.setMonthlySalary(jobPostDTO.getMonthlySalary());
		job.setProfessionalSummary(jobPostDTO.getProfessionalSummary());
		job.setNoticePeriod(jobPostDTO.getNoticePeriod());
		job.setYearsOfExperience(jobPostDTO.getYearsOfExperience());
		job.setSkills(jobPostDTO.getSkills());
		job.setDescription(jobPostDTO.getDescription());
		// Format LocalDateTime
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(jobPostDTO.getLastDateForApplication() + " 00:00", formatter);
		job.setLastDateForApplication(dateTime);
		job.setMinSalary(jobPostDTO.getMinSalary());
		job.setMaxSalary(jobPostDTO.getMaxSalary());
		job.setQualification(jobPostDTO.getQualification());
		job.setRequiredGender(jobPostDTO.getRequiredGender());

		return job;
	}
}
