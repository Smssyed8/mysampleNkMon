package com.mindfulqatar.jobportal.services;

import javax.servlet.http.HttpServletRequest;

import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.VerificationToken;

public interface VerificationTokenService {
	VerificationToken getByVerificationToken(String verificationToken);

	VerificationToken save(VerificationToken verificationToken);

	String authWithHttpServletRequest(HttpServletRequest request, Account account);

	void deleteBasedOnAccountId(Long accountId);
}