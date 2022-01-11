package com.mindfulqatar.jobportal.dto;

import javax.validation.constraints.NotNull;

public class JobPostDTO {

	private Long employerId;

	@NotNull
	private String jobTitle;

	private Long jobRole;
	private Long city;

	@NotNull
	private Long jobLevel;

	@NotNull
	private Long jobType;
	private Long companyIndustry;

	@NotNull
	private String typeOfWork;
	private Long monthlySalary;

	@NotNull
	private String professionalSummary;
	private int noticePeriod;
	private int yearsOfExperience;

	@NotNull
	private String skills;

	@NotNull
	private String description;

	private String lastDateForApplication;
	private Long minSalary;
	private Long maxSalary;

	@NotNull
	private String qualification;

	@NotNull
	private String requiredGender;

	// Getters and Setters
	// ===================

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Long getJobRole() {
		return jobRole;
	}

	public void setJobRole(Long jobRole) {
		this.jobRole = jobRole;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	public Long getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(Long jobLevel) {
		this.jobLevel = jobLevel;
	}

	public Long getJobType() {
		return jobType;
	}

	public void setJobType(Long jobType) {
		this.jobType = jobType;
	}

	public Long getCompanyIndustry() {
		return companyIndustry;
	}

	public void setCompanyIndustry(Long companyIndustry) {
		this.companyIndustry = companyIndustry;
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

	public String getProfessionalSummary() {
		return professionalSummary;
	}

	public void setProfessionalSummary(String professionalSummary) {
		this.professionalSummary = professionalSummary;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastDateForApplication() {
		return lastDateForApplication;
	}

	public void setLastDateForApplication(String lastDateForApplication) {
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

	public String getRequiredGender() {
		return requiredGender;
	}

	public void setRequiredGender(String requiredGender) {
		this.requiredGender = requiredGender;
	}
}
