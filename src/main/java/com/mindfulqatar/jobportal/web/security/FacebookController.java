package com.mindfulqatar.jobportal.web.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
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
public class FacebookController {
	// Creates a facebook connection using the given application id and secret key.
	private FacebookConnectionFactory factory = new FacebookConnectionFactory(FACEBOOK_CLIENT_ID,
			FACEBOOK_CLIENT_SECRET);

	@Autowired
	private AccountService accountService;

	@Autowired
	private AutomaticLoginService automaticLoginService;

	@Autowired
	private PasswordService passwordService;

	// Redirection uri.
	@GetMapping("/facebook/login")
	public String redirect() {
		// Creates the OAuth2.0 flow and performs the oauth handshake on behalf of the
		// user.
		OAuth2Operations operations = factory.getOAuthOperations();

		// Builds the OAuth2.0 authorize url and the scope parameters.
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri(BASE_URL + FACEBOOK_REDIRECT_URL);
		params.setScope("email, public_profile");

		// Url to redirect the user for authentication via OAuth2.0 authorization code
		// grant.
		String authUrl = operations.buildAuthenticateUrl(params);
		return "redirect:" + authUrl;
	}

	// Welcome page.
	@GetMapping("/forward/facebook/login")
	public String prodducer(@RequestParam("code") String authorizationCode, HttpServletRequest request) {
		// Creates the OAuth2.0 flow and performs the oauth handshake on behalf of the
		// user.
		OAuth2Operations operations = factory.getOAuthOperations();

		// OAuth2.0 access token.
		// "exchangeForAccess()" method exchanges the authorization code for an access
		// grant.
		AccessGrant accessToken = operations.exchangeForAccess(authorizationCode, BASE_URL + FACEBOOK_REDIRECT_URL,
				null);

		Connection<Facebook> connection = factory.createConnection(accessToken);

		// Getting the connection that the current user has with facebook.
		Facebook facebook = connection.getApi();
		// Fetching the details from the facebook.
		String[] fields = { "id", "name", "email", "about", "birthday" };
		User userProfile = facebook.fetchObject("me", User.class, fields);

		Account existing = null;

		if (userProfile.getEmail() != null) {
			existing = accountService.getAccountByEmail(userProfile.getEmail());
		} else {
			existing = accountService.getAccountByEmail(userProfile.getId() + "@facebook.com");
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

		if (userProfile.getEmail() != null && !userProfile.getEmail().isEmpty()) {
			accountDTO.setEmail(userProfile.getEmail());
			accountDTO.setUsername(accountDTO.getEmail());
		} else {
			accountDTO.setUsername(userProfile.getId() + "@facebook.com");
			accountDTO.setEmail(userProfile.getId() + "@facebook.com");
		}

		accountDTO.setMobilePhone("99999999");
		accountDTO.setName(userProfile.getName());

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