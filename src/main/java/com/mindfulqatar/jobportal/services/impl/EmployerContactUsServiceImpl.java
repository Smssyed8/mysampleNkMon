package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.EmployerContactUs;
import com.mindfulqatar.jobportal.repositories.EmployerContactUsRepository;
import com.mindfulqatar.jobportal.services.EmployerContactUsService;

@Service
public class EmployerContactUsServiceImpl implements EmployerContactUsService {

	@Autowired
	EmployerContactUsRepository employerContactUsRepository;

	@Override
	public List<EmployerContactUs> getAllEmails() {
		return employerContactUsRepository.findAll();
	}

	@Override
	public EmployerContactUs save(EmployerContactUs employerContact) {
		return employerContactUsRepository.save(employerContact);
	}
}
