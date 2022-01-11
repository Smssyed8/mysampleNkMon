package com.mindfulqatar.jobportal.services.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.VerificationToken;
import com.mindfulqatar.jobportal.repositories.VerificationTokenRepository;
import com.mindfulqatar.jobportal.services.EmailSenderService;
import com.mindfulqatar.jobportal.services.VerificationTokenService;
import static com.mindfulqatar.jobportal.constants.Constant.BASE_URL;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {

	@Autowired
	VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private EmailSenderService emailSenderService;

	@Override
	public VerificationToken getByVerificationToken(String verificationToken) {
		Optional<VerificationToken> token = verificationTokenRepository.findByVerificationToken(verificationToken);
		if (token.isPresent()) {
			return token.get();
		}
		return null;
	}

	@Override
	public VerificationToken save(VerificationToken verificationToken) {
		return verificationTokenRepository.save(verificationToken);
	}

	@Override
	public String authWithHttpServletRequest(HttpServletRequest request, Account account) {
		VerificationToken verificationToken = new VerificationToken(account);

		verificationToken = verificationTokenRepository.save(verificationToken);

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(account.getEmail());
		mailMessage.setSubject("MindfulQatar: Verify your email!");
		mailMessage.setFrom("mindful974@gmail.com");
		mailMessage.setText("To confirm your account, please click here : " + BASE_URL + "email/verify?token="
				+ verificationToken.getVerificationToken());

		emailSenderService.sendEmail(mailMessage);

		return "registration-success";
	}

	@Override
	public void deleteBasedOnAccountId(Long accountId) {
		verificationTokenRepository.deleteByAccountId(accountId);
	}
}
