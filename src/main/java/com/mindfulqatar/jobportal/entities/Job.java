package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "job")
public class Job implements Comparable<Job> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@Column(name = "job_title")
	@NotNull
	private String jobTitle;

	@Column(name = "job_role")
	private Long jobRole;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "job_level")
	@NotNull
	private Long jobLevel;

	@Column(name = "job_type")
	@NotNull
	private Long jobType;

	@Column(name = "company_industry")
	private Long companyIndustry;

	@Column(name = "type_of_work")
	@NotNull
	private String typeOfWork;

	@Column(name = "monthly_salary")
	private Long monthlySalary;

	@Column(name = "professional_summary")
	@NotNull
	private String professionalSummary;

	@Column(name = "notice_period")
	@NotNull
	private int noticePeriod;

	@Column(name = "years_of_experience")
	@NotNull
	private int yearsOfExperience;

	@NotNull
	private String skills;

	@NotNull
	private String description;

	@Column(name = "last_date_for_application")
	private LocalDateTime lastDateForApplication;

	@Column(name = "min_salary")
	private Long minSalary;

	@Column(name = "max_salary")
	private Long maxSalary;

	@NotNull
	private String qualification;

	@NotNull
	@Column(name = "required_gender")
	private String requiredGender;

	@Column(name = "created_on", columnDefinition = "CURRENT_TIMESTAMP", updatable = false)
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@Column(name = "updated_by")
	private Long updatedBy;

	@Transient
	private int createdYear;

	@Transient
	private int createdMonth;

	@Transient
	private int createdDay;

	@Transient
	private String createdStrMonth;

	@Transient
	private String createdOnFormatted;

	@Transient
	private List<Long> cityIds;

	@Transient
	private List<Long> jobRoles;

	@Transient
	private List<Long> companyIndustries;

	@Transient
	private List<Long> sectors;

	@Transient
	private int daysInterval;

	@Transient
	private List<Long> employers;

	@Transient
	private List<Long> jobLevels;

	@Transient
	private List<Long> companyTypes;

	@Transient
	private List<Long> jobTypes;

	@Transient
	private List<String> genders;

	@Transient
	private int lastDateForApplicationYear;

	@Transient
	private int lastDateForApplicationMonth;

	@Transient
	private int lastDateForApplicationDay;

	@Transient
	private String lastDateForApplicationStrMonth;

	@Transient
	private String lastDateForApplicationFormatted;

	@Transient
	private List<JobseekerJobMap> jobseekerJobMaps;

	@Transient
	private Long jobseekerJobMapsCount;

	public Job() {
	}

	public Job(Long jobId) {
		this.id = jobId;
	}

	@PrePersist
	private void onCreate() {
		setCreatedOn(LocalDateTime.now());
	}

	@PostLoad
	private void onLoad() {
		this.createdYear = createdOn.getYear();
		this.createdMonth = createdOn.getMonthValue();
		this.createdDay = createdOn.getDayOfMonth();
		this.createdStrMonth = createdOn.getMonth().toString();
		this.createdOnFormatted = this.createdStrMonth + " " + this.createdDay + ", " + this.createdYear;

		this.lastDateForApplicationYear = lastDateForApplication.getYear();
		this.lastDateForApplicationMonth = lastDateForApplication.getMonthValue();
		this.lastDateForApplicationDay = lastDateForApplication.getDayOfMonth();
		this.lastDateForApplicationStrMonth = createdOn.getMonth().toString();
		this.lastDateForApplicationFormatted = this.lastDateForApplicationStrMonth + " "
				+ this.lastDateForApplicationDay + ", " + this.lastDateForApplicationYear;
	}

	// Getters and Setters
	// ===================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
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

	public String getRequiredGender() {
		return requiredGender;
	}

	public void setRequiredGender(String requiredGender) {
		this.requiredGender = requiredGender;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
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

	public String getCreatedOnFormatted() {
		return createdOnFormatted;
	}

	public void setCreatedOnFormatted(String createdOnFormatted) {
		this.createdOnFormatted = createdOnFormatted;
	}

	public List<Long> getCityIds() {
		return cityIds;
	}

	public void setCityIds(List<Long> cityIds) {
		this.cityIds = cityIds;
	}

	public List<Long> getJobRoles() {
		return jobRoles;
	}

	public void setJobRoles(List<Long> jobRoles) {
		this.jobRoles = jobRoles;
	}

	public List<Long> getCompanyIndustries() {
		return companyIndustries;
	}

	public void setCompanyIndustries(List<Long> companyIndustries) {
		this.companyIndustries = companyIndustries;
	}

	public List<Long> getSectors() {
		return sectors;
	}

	public void setSectors(List<Long> sectors) {
		this.sectors = sectors;
	}

	public int getDaysInterval() {
		return daysInterval;
	}

	public void setDaysInterval(int daysInterval) {
		this.daysInterval = daysInterval;
	}

	public List<Long> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Long> employers) {
		this.employers = employers;
	}

	public List<Long> getJobLevels() {
		return jobLevels;
	}

	public void setJobLevels(List<Long> jobLevels) {
		this.jobLevels = jobLevels;
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

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}

	public String getLastDateForApplicationFormatted() {
		return lastDateForApplicationFormatted;
	}

	public void setLastDateForApplicationFormatted(String lastDateForApplicationFormatted) {
		this.lastDateForApplicationFormatted = lastDateForApplicationFormatted;
	}

	public List<JobseekerJobMap> getJobseekerJobMaps() {
		return jobseekerJobMaps;
	}

	public void setJobseekerJobMaps(List<JobseekerJobMap> jobseekerJobMaps) {
		this.jobseekerJobMaps = jobseekerJobMaps;
	}

	public Long getJobseekerJobMapsCount() {
		return jobseekerJobMapsCount;
	}

	public void setJobseekerJobMapsCount(Long jobseekerJobMapsCount) {
		this.jobseekerJobMapsCount = jobseekerJobMapsCount;
	}

	@Override
	public int compareTo(Job job) {
		return this.jobTitle.compareTo(job.jobTitle);
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", jobRole=" + jobRole + ", location=" + city.getCity()
				+ ", jobLevel=" + jobLevel + ", companyIndustry=" + companyIndustry + ", typeOfWork=" + typeOfWork
				+ ", monthlySalary=" + monthlySalary + ", professionalSummary=" + professionalSummary
				+ ", noticePeriod=" + noticePeriod + ", yearsOfExperience=" + yearsOfExperience + ", skills=" + skills
				+ ", description=" + description + ", lastDateForApplication=" + lastDateForApplication + ", minSalary="
				+ minSalary + ", maxSalary=" + maxSalary + ", qualification=" + qualification + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + ", createdOnFormatted="
				+ createdOnFormatted + "]";
	}
}
