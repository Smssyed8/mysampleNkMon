package com.mindfulqatar.jobportal.dto;

import javax.validation.constraints.NotNull;

public class EmployerEditDTO {

	@NotNull
	private String companyName;
	private Long companyIndustry;
	private Long companyType;
	private Long packageId;
	private int taxRegistrationNumber;
	private int currentJobPostingCount;
	private int currentCvSearchCount;
	private String crnNumber;
	private String address;
	private String designation;

	// Getters and Setters
	// ===================

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getCompanyIndustry() {
		return companyIndustry;
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

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public int getTaxRegistrationNumber() {
		return taxRegistrationNumber;
	}

	public void setTaxRegistrationNumber(int taxRegistrationNumber) {
		this.taxRegistrationNumber = taxRegistrationNumber;
	}

	public int getCurrentJobPostingCount() {
		return currentJobPostingCount;
	}

	public void setCurrentJobPostingCount(int currentJobPostingCount) {
		this.currentJobPostingCount = currentJobPostingCount;
	}

	public String getCrnNumber() {
		return crnNumber;
	}

	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getCurrentCvSearchCount() {
		return currentCvSearchCount;
	}

	public void setCurrentCvSearchCount(int currentCvSearchCount) {
		this.currentCvSearchCount = currentCvSearchCount;
	}
}
