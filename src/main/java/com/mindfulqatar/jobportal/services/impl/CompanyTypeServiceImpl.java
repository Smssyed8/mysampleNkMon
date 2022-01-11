package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.CompanyType;
import com.mindfulqatar.jobportal.repositories.CompanyTypeRepository;
import com.mindfulqatar.jobportal.services.CompanyTypeService;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {

	@Autowired
	CompanyTypeRepository companyTypeRepository;

	@Override
	public List<CompanyType> getAllCompanyTypes() {
		return companyTypeRepository.findAll();
	}
}
