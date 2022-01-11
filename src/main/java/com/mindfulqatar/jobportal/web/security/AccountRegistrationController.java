package com.mindfulqatar.jobportal.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindfulqatar.jobportal.dto.AccountRegistrationDTO;
import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.services.AccountService;
import com.mindfulqatar.jobportal.services.CountryService;
import com.mindfulqatar.jobportal.services.SectorService;
import com.mindfulqatar.jobportal.services.VerificationTokenService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class AccountRegistrationController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private SectorService serviceSector;

	@Autowired
	private CountryService serviceCountry;

	@Autowired
	private VerificationTokenService serviceVerificationToken;

	@ModelAttribute("account")
	public AccountRegistrationDTO accountRegistrationDTO() {
		return new AccountRegistrationDTO();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("sectors", serviceSector.getAllSectors());
		model.addAttribute("countries", serviceCountry.getAllCountries());
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(Model model, @ModelAttribute("account") @Valid AccountRegistrationDTO accountDTO,
			BindingResult result, HttpServletRequest request,
			@RequestParam(required = false, name = "activePageName") String activePageName) {

		Account existing = accountService.getAccountByEmail(accountDTO.getEmail());
		if (existing != null) {
			model.addAttribute("emailError", "There is already an account registered with that email");
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		if (result.hasErrors()) {
			model.addAttribute("activePageName", activePageName);
			model.addAttribute("sectors", serviceSector.getAllSectors());
			model.addAttribute("countries", serviceCountry.getAllCountries());
			return "registration";
		}

		accountDTO.setUsername(accountDTO.getEmail());

		Account savedAccount = accountService.save(accountDTO);

		model.addAttribute("name", accountDTO.getName());
		model.addAttribute("email", accountDTO.getEmail());
		model.addAttribute("activePageName", activePageName);

		return serviceVerificationToken.authWithHttpServletRequest(request, savedAccount);
	}
}