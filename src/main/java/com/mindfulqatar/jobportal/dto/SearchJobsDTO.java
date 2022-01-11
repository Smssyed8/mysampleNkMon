package com.mindfulqatar.jobportal.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SearchJobsDTO {

	private Long id;
	private List<Long> employers;
	private String jobTitle;
	private List<Long> jobRoles;
	private List<Long> cityIds;
	private List<Long> jobLevels;
	private List<Long> jobTypes;
	private List<Long> companyIndustries;
	private List<Long> companySectors;
	private List<Long> companyTypes;
	private String typeOfWork;
	private Long monthlySalary;
	private int noticePeriod;
	private int yearsOfExperience;
	private String skills;
	private LocalDateTime lastDateForApplication;
	private Long minSalary;
	private Long maxSalary;
	private String qualification;
	private LocalDateTime createdOn;
	private Long createdBy;
	private LocalDateTime updatedOn;
	private int daysInterval;
	private Long updatedBy;
	private List<String> genders;

	// Getters and Setters
	// ===================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Long> employers) {
		this.employers = employers;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<Long> getJobRoles() {
		return jobRoles;
	}

	public void setJobRoles(List<Long> jobRoles) {
		this.jobRoles = jobRoles;
	}

	public List<Long> getCityIds() {
		return cityIds;
	}

	public void setCityIds(List<Long> cityIds) {
		this.cityIds = cityIds;
	}

	public List<Long> getJobLevels() {
		return jobLevels;
	}

	public void setJobLevels(List<Long> jobLevels) {
		this.jobLevels = jobLevels;
	}

	public List<Long> getCompanyIndustries() {
		return companyIndustries;
	}

	public void setCompanyIndustries(List<Long> companyIndustries) {
		this.companyIndustries = companyIndustries;
	}

	public List<Long> getCompanySectors() {
		return companySectors;
	}

	public void setCompanySectors(List<Long> companySectors) {
		this.companySectors = companySectors;
	}

	public List<Long> getCompanyTypes() {
		return companyTypes;
	}

	public void setCompanyTypes(List<Long> companyTypes) {
		this.companyTypes = companyTypes;
	}

	public List<Long> getJobTypes() {
		return jobTypes;
	}

	public void setJobTypes(List<Long> jobTypes) {
		this.jobTypes = jobTypes;
	}

	public String getTypeOfWork() {
		return typeOfWork;
	}

	public void setTypeOfWork(String typeOfWork) {
		this.typeOfWork = typeOfWork;
	}

	public Long getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(Long monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public LocalDateTime getLastDateForApplication() {
		return lastDateForApplication;
	}

	public void setLastDateForApplication(LocalDateTime lastDateForApplication) {
		this.lastDateForApplication = lastDateForApplication;
	}

	public Long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public Long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getDaysInterval() {
		return daysInterval;
	}

	public void setDaysInterval(int daysInterval) {
		this.daysInterval = daysInterval;
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}
}
