package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.CompanyIndustry;

public interface CompanyIndustryService {
	List<CompanyIndustry> getCompanyIndustriesBySectorId(Long sectorId);

	List<CompanyIndustry> getAllCompanyIndustries();

	CompanyIndustry save(CompanyIndustry companyIndustry);

	CompanyIndustry getCompanyIndustryById(Long companyIndustryId);
}