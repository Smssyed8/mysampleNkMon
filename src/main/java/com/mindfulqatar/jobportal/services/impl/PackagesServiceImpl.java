package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Packages;
import com.mindfulqatar.jobportal.repositories.PackagesRepository;
import com.mindfulqatar.jobportal.services.PackagesService;

@Service
public class PackagesServiceImpl implements PackagesService {

	@Autowired
	PackagesRepository packagesRepository;

	@Override
	public List<Packages> getAllPackages() {
		return packagesRepository.findAll();
	}

	@Override
	public Packages getPackageById(Long packageId) {
		return packagesRepository.getOne(packageId);
	}
}
