package com.mindfulqatar.jobportal.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.CompanyIndustry;
import com.mindfulqatar.jobportal.repositories.CompanyIndustryRepository;
import com.mindfulqatar.jobportal.services.CompanyIndustryService;

@Service
public class CompanyIndustryServiceImpl implements CompanyIndustryService {

	@Autowired
	CompanyIndustryRepository companyIndustryRepository;

	@Override
	public CompanyIndustry save(CompanyIndustry companyIndustry) {
		return companyIndustryRepository.save(companyIndustry);
	}

	@Override
	public List<CompanyIndustry> getCompanyIndustriesBySectorId(Long sectorId) {
		return companyIndustryRepository.findBySectorId(sectorId);
	}

	@Override
	public List<CompanyIndustry> getAllCompanyIndustries() {
		return companyIndustryRepository.findAll();
	}

	@Override
	public CompanyIndustry getCompanyIndustryById(Long companyIndustryId) {
		Optional<CompanyIndustry> ci = companyIndustryRepository.findById(companyIndustryId);
		if (ci.isPresent()) {
			return ci.get();
		}
		return null;
	}
}
