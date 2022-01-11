package com.mindfulqatar.jobportal.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.repositories.AccountRepository;

import static com.mindfulqatar.jobportal.constants.Constant.BASE_URL;

public class JobportalAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	private AccountRepository userRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		String targetUrl = determineTargetUrl(request, authentication);

		if (response.isCommitted()) {
//			logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(HttpServletRequest request, Authentication authentication) {
		boolean isSupport = false;
		boolean isAdmin = false;
		boolean isJobseeker = false;
		boolean isEmployer = false;

		Optional<Account> currentLoggedInUser = userRepository.findByEmail(authentication.getName());

		if (!currentLoggedInUser.isPresent())
			return "/error";

		if (!currentLoggedInUser.get().getEnabled()) {
			return "/error/verify-email";
		}

		if (!currentLoggedInUser.get().getApproved()) {
			return "/error/approval-needed";
		}

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_JOBSEEKER")) {
				isJobseeker = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_EMPLOYER")) {
				isEmployer = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_SUPPORT")) {
				isSupport = true;
				break;
			}
		}

		HttpSession session = request.getSession();

		if (isAdmin) {
			if (session != null && !session.getAttribute("url_prior_login").toString().contains("/login")
					&& !session.getAttribute("url_prior_login").toString().contains("/employer")
					&& !session.getAttribute("url_prior_login").toString().contains("/jobseeker")
					&& !session.getAttribute("url_prior_login").toString().equals(BASE_URL)) {
				return session.getAttribute("url_prior_login").toString();
			} else {
				return "/admin/home";
			}
		} else if (isJobseeker) {
			if (session != null && !session.getAttribute("url_prior_login").toString().contains("/login")
					&& !session.getAttribute("url_prior_login").toString().contains("/employer")
					&& !session.getAttribute("url_prior_login").toString().contains("/admin")
					&& !session.getAttribute("url_prior_login").toString().equals(BASE_URL)) {
				return session.getAttribute("url_prior_login").toString();
			} else {
				return "/jobseeker/home";
			}
		} else if (isEmployer) {
			if (session != null && !session.getAttribute("url_prior_login").toString().contains("/login")
					&& !session.getAttribute("url_prior_login").toString().contains("/jobseeker")
					&& !session.getAttribute("url_prior_login").toString().contains("/admin")
					&& !session.getAttribute("url_prior_login").toString().equals(BASE_URL)) {
				return session.getAttribute("url_prior_login").toString();
			} else {
				return "/employer/home";
			}
		} else if (isSupport) {
			return "/support/home";
		} else {
			return "/error";
		}

	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
}
