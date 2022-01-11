package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "packages")
public class Packages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String packageName;

	@Column(name = "package_description")
	private String packageDescription;

	private Long price;

	@Column(name = "selling_price")
	private Long sellingPrice;

	@Column(name = "cv_search_limit")
	private int cvSearchLimit;

	@Column(name = "job_posting_limit")
	private int jobPostingLimit;

	@Column(name = "is_unlimited_cv_search")
	private Boolean isUnlimitedCvSearch;

	@Column(name = "is_unlimited_job_posting")
	private Boolean isUnlimitedJobPosting;

	@Column(name = "duration_in_month")
	private int durationInMonth;

	@Column(name = "created_on", columnDefinition = "CURRENT_TIMESTAMP", updatable = false)
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

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

	public Packages() {
	}

	public Packages(Long packageId) {
		this.id = packageId;
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Long sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getCvSearchLimit() {
		return cvSearchLimit;
	}

	public void setCvSearchLimit(int cvSearchLimit) {
		this.cvSearchLimit = cvSearchLimit;
	}

	public int getJobPostingLimit() {
		return jobPostingLimit;
	}

	public void setJobPostingLimit(int jobPostingLimit) {
		this.jobPostingLimit = jobPostingLimit;
	}

	public Boolean getIsUnlimitedCvSearch() {
		return isUnlimitedCvSearch;
	}

	public void setIsUnlimitedCvSearch(Boolean isUnlimitedCvSearch) {
		this.isUnlimitedCvSearch = isUnlimitedCvSearch;
	}

	public Boolean getIsUnlimitedJobPosting() {
		return isUnlimitedJobPosting;
	}

	public void setIsUnlimitedJobPosting(Boolean isUnlimitedJobPosting) {
		this.isUnlimitedJobPosting = isUnlimitedJobPosting;
	}

	public int getDurationInMonth() {
		return durationInMonth;
	}

	public void setDurationInMonth(int durationInMonth) {
		this.durationInMonth = durationInMonth;
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
}
