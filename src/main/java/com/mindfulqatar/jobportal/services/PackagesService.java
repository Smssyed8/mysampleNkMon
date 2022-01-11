package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.Packages;

public interface PackagesService {
	List<Packages> getAllPackages();

	Packages getPackageById(Long packageId);
}