package com.mindfulqatar.jobportal.web.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfileFull;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindfulqatar.jobportal.security.AutomaticLoginService;
import com.mindfulqatar.jobportal.dto.AccountRegistrationDTO;
import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.Role;
import com.mindfulqatar.jobportal.services.AccountService;
import com.mindfulqatar.jobportal.services.PasswordService;
import static com.mindfulqatar.jobportal.constants.Constant.*;

@Controller
public class LinkedinController {
	// Creates a linkedin connection using the given application id and secret key.
	private LinkedInConnectionFactory factory = new LinkedInConnectionFactory(LINKEDIN_CLIENT_ID,
			LINKEDIN_CLIENT_SECRET);

	@Autowired
	private AccountService accountService;

	@Autowired
	private AutomaticLoginService automaticLoginService;

	@Autowired
	private PasswordService passwordService;

	// Redirection uri.
	@GetMapping("/linkedin/login")
	public String redirect() {
		// Creates the OAuth2.0 flow and performs the oauth handshake on behalf of the
		// user.
		OAuth2Operations operations = factory.getOAuthOperations();

		// Builds the OAuth2.0 authorize url and the scope parameters.
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri(BASE_URL + LINKEDIN_REDIRECT_URL);

		// Url to redirect the user for authentication via OAuth2.0 authorization code
		// grant.
		String authUrl = operations.buildAuthenticateUrl(params) + LINKEDIN_SCOPE;
		return "redirect:" + authUrl;
	}

	// Welcome page.
	@GetMapping("/forward/linkedin/login")
	public String prodducer(@RequestParam("code") String authorizationCode, HttpServletRequest request) {
		// Creates the OAuth2.0 flow and performs the oauth handshake on behalf of the
		// user.
		OAuth2Operations operations = factory.getOAuthOperations();

		// OAuth2.0 access token.
		// "exchangeForAccess()" method exchanges the authorization code for an access
		// grant.
		AccessGrant accessToken = operations.exchangeForAccess(authorizationCode, BASE_URL + LINKEDIN_REDIRECT_URL,
				null);

		Connection<LinkedIn> connection = factory.createConnection(accessToken);

		// Getting the connection that the current user has with linkedin.
		LinkedIn linkedin = connection.getApi();
		// Fetching the details from the linkedin.
		LinkedInProfileFull userProfile = linkedin.profileOperations().getUserProfileFull();

		Account existing = null;

		if (userProfile.getEmailAddress() != null) {
			existing = accountService.getAccountByEmail(userProfile.getEmailAddress());
		} else {
			existing = accountService.getAccountByEmail(userProfile.getId() + "@linkedin.com");
		}

		// If account already exists login with that account and forward the user to
		// appropriate home page
		if (existing != null) {
			boolean result = automaticLoginService
					.authenticateUserAndInitializeSessionByUsername(existing.getUsername(), request);

			if (result) {
				List<Role> roles = existing.getRoles();
				for (Role role : roles) {
					if (role.getRole().equals("ROLE_ADMIN")) {
						return "redirect:/admin/home";
					} else if (role.getRole().equals("ROLE_JOBSEEKER")) {
						return "redirect:/jobseeker/home";
					} else if (role.getRole().equals("ROLE_EMPLOYER")) {
						return "redirect:/employer/home";
					}
				}
			}
		}

		// If account not exists register the user as jobseeker forward the user to
		// appropriate home page
		AccountRegistrationDTO accountDTO = new AccountRegistrationDTO();

		if (userProfile.getEmailAddress() != null && !userProfile.getEmailAddress().isEmpty()) {
			accountDTO.setEmail(userProfile.getEmailAddress());
			accountDTO.setUsername(accountDTO.getEmail());
		} else {
			accountDTO.setUsername(userProfile.getId() + "@linkedin.com");
			accountDTO.setEmail(userProfile.getId() + "@linkedin.com");
		}

		accountDTO.setMobilePhone("99999999");
		accountDTO.setName(userProfile.getFirstName() + " " + userProfile.getLastName());

		// By default set the nationality as Qatar
		accountDTO.setNationality(143L);
		accountDTO.setRole("ROLE_JOBSEEKER");
		accountDTO.setPassword(passwordService.getRandomPassword(20).toString());

		// Set 1st sector as default sector
		accountDTO.setSector(1L);
		Account savedAccount = accountService.save(accountDTO);

		// After saving the account login that account
		boolean result = automaticLoginService
				.authenticateUserAndInitializeSessionByUsername(savedAccount.getUsername(), request);

		if (result)
			return "redirect:/jobseeker/home";

		return "redirect:/error";
	}

}