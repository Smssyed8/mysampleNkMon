package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.WebContactUs;
import com.mindfulqatar.jobportal.repositories.WebContactUsRepository;
import com.mindfulqatar.jobportal.services.WebContactUsService;

@Service
public class WebContactUsServiceImpl implements WebContactUsService {

	@Autowired
	WebContactUsRepository webContactUsRepository;

	@Override
	public List<WebContactUs> getAllEmails() {
		return webContactUsRepository.findAll();
	}

	@Override
	public WebContactUs save(WebContactUs webContactUs) {
		return webContactUsRepository.save(webContactUs);
	}
}
