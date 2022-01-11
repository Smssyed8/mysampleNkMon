package com.mindfulqatar.jobportal.dto;

public class SearchEmployersDTO {

	private Long id;
	private String companyName;
	private Long companyIndustry;
	private Long companySector;
	private Long companyType;
	private Long companyPackage;

	// Getters and Setters
	// ===================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getCompanySector() {
		return companySector;
	}

	public void setCompanySector(Long companySector) {
		this.companySector = companySector;
	}

	public Long getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Long companyType) {
		this.companyType = companyType;
	}

	public Long getCompanyPackage() {
		return companyPackage;
	}

	public void setCompanyPackage(Long companyPackage) {
		this.companyPackage = companyPackage;
	}
}
