package com.mindfulqatar.jobportal.services;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.mail.SimpleMailMessage;

public interface EmailSenderService {
	void sendEmail(SimpleMailMessage email);

	void sendEmailWithAttachment(String to, String subject, String htmlText) throws MessagingException, IOException;
}