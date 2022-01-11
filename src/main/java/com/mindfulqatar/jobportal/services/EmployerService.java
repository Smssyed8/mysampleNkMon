package com.mindfulqatar.jobportal.services;

import com.mindfulqatar.jobportal.entities.Employer;

import java.util.List;

import com.mindfulqatar.jobportal.dto.EmployerDTO;
import com.mindfulqatar.jobportal.entities.Account;

public interface EmployerService {
	List<Employer> searchEmployers(Employer employer);

	Employer getEmployerByEmail(String email);

	Employer save(Employer employer);

	Account save(EmployerDTO registration);

	Boolean isValidEmployer(Long accountId);

	long countEmployers();

	void deleteEmployer(Long id);
}
