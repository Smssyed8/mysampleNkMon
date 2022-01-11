package com.mindfulqatar.jobportal.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.mindfulqatar.jobportal.services.AccountService;

import static com.mindfulqatar.jobportal.constants.Constant.BASE_URL;

@Controller
public class LoginController {

	@Autowired
	AccountService servAccount;

	@GetMapping(value = "/login")
	public String loginPage(HttpServletRequest request, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		String referrer = request.getHeader("Referer");

		if (referrer != null) {
			request.getSession().setAttribute("url_prior_login", referrer);
		}

		String errorMessage = null;
		if (error != null)
			errorMessage = "Username or Password is incorrect !!";

		if (logout != null)
			errorMessage = "You have been successfully logged out !!";

		model.addAttribute("errorMessage", errorMessage);

		if (action != null && action.equals("upload-resume"))
			model.addAttribute("action", action);

		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?logout=true";
	}

	@GetMapping(value = "/error")
	public String errorPage() {
		return "error";
	}

	@GetMapping(value = "/custom-message")
	public String errorCustomErrorPage(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "errorMessage", required = false) String errorMessage,
			@RequestParam(value = "message", required = false) String message,
			@RequestParam(value = "verifyEmail", required = false) Boolean verifyEmail) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		model.addAttribute("errorMessage", errorMessage);
		model.addAttribute("message", message);
		model.addAttribute("verifyEmail", verifyEmail);
		model.addAttribute("baseUrl", BASE_URL);

		return "custom-message";
	}
}
