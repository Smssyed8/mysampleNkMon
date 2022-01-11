package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mindfulqatar.jobportal.entities.Account;

@Entity
@Table(name = "jobseeker")
public class Jobseeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;

	@Column(name = "work_experience")
	private int workExperience;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_industry")
	private Long companyIndustry;

	@Column(name = "company_size")
	private int companySize;

	@Column(name = "current_salary")
	private int currentSalary;

	@Column(name = "languages_known")
	private String languagesKnown;

	private String hobbies;

	private String interests;

	private String skills;

	@Column(name = "sector")
	private Long sector;

	@Column(name = "career_level")
	private String careerLevel;

	@JoinColumn(name = "job_role")
	private Long jobRole;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "resume_path")
	private String resumePath;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "desc_job_looking_for")
	private String descJobLookingFor;

	@Column(name = "linkedin_profile")
	private String linkedinProfile;

	@Column(name = "facebook_profile")
	private String facebookProfile;

	@Column(name = "video_profile")
	private String videoProfile;

	@Column(name = "expected_salary")
	private int expectedSalary;

	@Column(name = "notice_period")
	private int noticePeriod;

	@Column(name = "is_anonymous")
	private Boolean isAnonymous;

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

	public Jobseeker() {
	}

	public Jobseeker(long jobseekerId) {
		this.id = jobseekerId;
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
	}

	// Getters and Setters
	// ===================

	public Long getId() {
		return id;
	}

	public Account getAccount() {
		return account;
	}

	public int getWorkExperience() {
		return workExperience;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Long getCompanyIndustry() {
		return companyIndustry;
	}

	public int getCompanySize() {
		return companySize;
	}

	public int getCurrentSalary() {
		return currentSalary;
	}

	public String getLanguagesKnown() {
		return languagesKnown;
	}

	public String getHobbies() {
		return hobbies;
	}

	public String getInterests() {
		return interests;
	}

	public String getSkills() {
		return skills;
	}

	public Long getSector() {
		return sector;
	}

	public String getCareerLevel() {
		return careerLevel;
	}

	public Long getJobRole() {
		return jobRole;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getResumePath() {
		return resumePath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getDescJobLookingFor() {
		return descJobLookingFor;
	}

	public String getLinkedinProfile() {
		return linkedinProfile;
	}

	public String getFacebookProfile() {
		return facebookProfile;
	}

	public String getVideoProfile() {
		return videoProfile;
	}

	public int getExpectedSalary() {
		return expectedSalary;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public int getCreatedYear() {
		return createdYear;
	}

	public int getCreatedMonth() {
		return createdMonth;
	}

	public int getCreatedDay() {
		return createdDay;
	}

	public String getCreatedStrMonth() {
		return createdStrMonth;
	}

	public String getCreatedOnFormatted() {
		return createdOnFormatted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyIndustry(Long companyIndustry) {
		this.companyIndustry = companyIndustry;
	}

	public void setCompanySize(int companySize) {
		this.companySize = companySize;
	}

	public void setCurrentSalary(int currentSalary) {
		this.currentSalary = currentSalary;
	}

	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public void setSector(Long sector) {
		this.sector = sector;
	}

	public void setCareerLevel(String careerLevel) {
		this.careerLevel = careerLevel;
	}

	public void setJobRole(Long jobRole) {
		this.jobRole = jobRole;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setDescJobLookingFor(String descJobLookingFor) {
		this.descJobLookingFor = descJobLookingFor;
	}

	public void setLinkedinProfile(String linkedinProfile) {
		this.linkedinProfile = linkedinProfile;
	}

	public void setFacebookProfile(String facebookProfile) {
		this.facebookProfile = facebookProfile;
	}

	public void setVideoProfile(String videoProfile) {
		this.videoProfile = videoProfile;
	}

	public void setExpectedSalary(int expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setCreatedYear(int createdYear) {
		this.createdYear = createdYear;
	}

	public void setCreatedMonth(int createdMonth) {
		this.createdMonth = createdMonth;
	}

	public void setCreatedDay(int createdDay) {
		this.createdDay = createdDay;
	}

	public void setCreatedStrMonth(String createdStrMonth) {
		this.createdStrMonth = createdStrMonth;
	}

	public void setCreatedOnFormatted(String createdOnFormatted) {
		this.createdOnFormatted = createdOnFormatted;
	}

	@Override
	public String toString() {
		return "Jobseeker [id=" + id + ", account=" + account + ", workExperience=" + workExperience + ", companyName="
				+ companyName + ", companyIndustry=" + companyIndustry + ", companySize=" + companySize
				+ ", currentSalary=" + currentSalary + ", languagesKnown=" + languagesKnown + ", hobbies=" + hobbies
				+ ", interests=" + interests + ", skills=" + skills + ", sector=" + sector + ", careerLevel="
				+ careerLevel + ", jobRole=" + jobRole + ", jobTitle=" + jobTitle + ", resumePath=" + resumePath
				+ ", imagePath=" + imagePath + ", descJobLookingFor=" + descJobLookingFor + ", linkedinProfile="
				+ linkedinProfile + ", facebookProfile=" + facebookProfile + ", videoProfile=" + videoProfile
				+ ", expectedSalary=" + expectedSalary + ", noticePeriod=" + noticePeriod + ", isAnonymous="
				+ isAnonymous + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy
				+ ", createdOnFormatted=" + createdOnFormatted + "]";
	}
}
