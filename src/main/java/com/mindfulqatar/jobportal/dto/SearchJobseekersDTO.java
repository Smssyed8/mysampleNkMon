package com.mindfulqatar.jobportal.dto;

public class SearchJobseekersDTO {

	private Long id;
	private String companyName;
	private Long companyIndustry;
	private Long companySector;
	private int minExperience;
	private int maxExperience;
	private Long cityId;
	private String keywords;

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

	public int getMinExperience() {
		return minExperience;
	}

	public void setMinExperience(int minExperience) {
		this.minExperience = minExperience;
	}

	public int getMaxExperience() {
		return maxExperience;
	}

	public void setMaxExperience(int maxExperience) {
		this.maxExperience = maxExperience;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
