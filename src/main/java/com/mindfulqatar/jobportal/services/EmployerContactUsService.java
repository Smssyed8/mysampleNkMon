package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.EmployerContactUs;

public interface EmployerContactUsService {
	List<EmployerContactUs> getAllEmails();

	EmployerContactUs save(EmployerContactUs employerContactUs);
}