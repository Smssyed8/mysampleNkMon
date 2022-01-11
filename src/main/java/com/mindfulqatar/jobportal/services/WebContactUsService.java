package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.WebContactUs;

public interface WebContactUsService {
	List<WebContactUs> getAllEmails();

	WebContactUs save(WebContactUs webContactUs);
}