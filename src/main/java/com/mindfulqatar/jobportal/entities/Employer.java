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
@Table(name = "employer")
public class Employer implements Comparable<Employer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "id")
	private Account account;

	@Column(name = "account_id")
	private Long accountId;

	private String designation;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_industry")
	private Long companyIndustry;

	@Column(name = "company_type")
	private Long companyType;

	@Column(name = "sector")
	private Long sector;

	@Column(name = "tax_registration_number")
	private int taxRegistrationNumber;

	@Column(name = "current_job_posting_count")
	private int currentJobPostingCount;

	@Column(name = "current_cv_search_count")
	private int currentCvSearchCount;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "crn_number")
	private String crnNumber;

	@Column(name = "package_id")
	private Long packageId;

	private String address;

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

	public Employer() {
	}

	public Employer(Long employerId) {
		this.id = employerId;
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

	public Long getAccountId() {
		return accountId;
	}

	public String getDesignation() {
		return designation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Long getCompanyIndustry() {
		return companyIndustry;
	}

	public Long getSector() {
		return sector;
	}

	public int getTaxRegistrationNumber() {
		return taxRegistrationNumber;
	}

	public int getCurrentJobPostingCount() {
		return currentJobPostingCount;
	}

	public int getCurrentCvSearchCount() {
		return currentCvSearchCount;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getCrnNumber() {
		return crnNumber;
	}

	public Long getPackageId() {
		return packageId;
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

	public String getCreatedOnFormatted() {
		return createdOnFormatted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyIndustry(Long companyIndustry) {
		this.companyIndustry = companyIndustry;
	}

	public Long getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Long companyType) {
		this.companyType = companyType;
	}

	public void setSector(Long sector) {
		this.sector = sector;
	}

	public void setTaxRegistrationNumber(int taxRegistrationNumber) {
		this.taxRegistrationNumber = taxRegistrationNumber;
	}

	public void setCurrentJobPostingCount(int currentJobPostingCount) {
		this.currentJobPostingCount = currentJobPostingCount;
	}

	public void setCurrentCvSearchCount(int currentCvSearchCount) {
		this.currentCvSearchCount = currentCvSearchCount;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public void setCreatedOnFormatted(String createdOnFormatted) {
		this.createdOnFormatted = createdOnFormatted;
	}

	@Override
	public int compareTo(Employer employer) {
		return this.companyName.compareTo(employer.companyName);
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", account=" + account + ", accountId=" + accountId + ", designation="
				+ designation + ", companyName=" + companyName + ", sector=" + sector + ", taxRegistrationNumber="
				+ taxRegistrationNumber + ", currentJobPostingCount=" + currentJobPostingCount
				+ ", currentCvSearchCount=" + currentCvSearchCount + ", imagePath=" + imagePath + ", crnNumber="
				+ crnNumber + ", packageId=" + packageId + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", updatedBy=" + updatedBy + ", createdOnFormatted=" + createdOnFormatted + "]";
	}
}
