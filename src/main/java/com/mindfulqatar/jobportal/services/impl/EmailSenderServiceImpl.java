package com.mindfulqatar.jobportal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.services.EmailSenderService;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(SimpleMailMessage email) {
		javaMailSender.send(email);
	}

	@Override
	public void sendEmailWithAttachment(String to, String subject, String htmlText)
			throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		// Create mime message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(htmlText, true);

//		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

		javaMailSender.send(msg);
	}
}
