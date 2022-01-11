package com.mindfulqatar.jobportal.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Employer;
import com.mindfulqatar.jobportal.entities.Jobseeker;
import com.mindfulqatar.jobportal.services.EmployerService;
import com.mindfulqatar.jobportal.services.JobseekerService;
import com.mindfulqatar.jobportal.dto.AccountRegistrationDTO;
import com.mindfulqatar.jobportal.dto.UserDTO;
import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.Country;
import com.mindfulqatar.jobportal.entities.Role;
import com.mindfulqatar.jobportal.mapper.AccountMapper;
import com.mindfulqatar.jobportal.repositories.AccountRepository;
import com.mindfulqatar.jobportal.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	EmployerService employerService;

	@Autowired
	JobseekerService jobseekerService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Account getAccountByEmail(String email) {
		Optional<Account> account = accountRepository.findByEmail(email);
		if (account.isPresent()) {
			return account.get();
		}
		return null;
	}

	@Override
	public Account save(AccountRegistrationDTO registration) {
		Country country = new Country(registration.getNationality());

		Account account = new Account();
		account.setName(registration.getName());
		account.setUsername(registration.getUsername());
		account.setMobilePhone(registration.getMobilePhone());
		account.setEmail(registration.getEmail());
		account.setNationality(country);
		account.setPassword(passwordEncoder.encode(registration.getPassword()));

		switch (registration.getRole()) {
		case "ROLE_JOBSEEKER":
			account.setRoles(Arrays.asList(new Role("ROLE_JOBSEEKER", LocalDateTime.now())));
			account.setApproved(true);

			account = accountRepository.save(account);

			Jobseeker jobseeker = new Jobseeker();
			jobseeker.setAccount(new Account(account.getId()));
			jobseeker.setSector(registration.getSector());

			jobseekerService.save(jobseeker);
			break;
		case "ROLE_EMPLOYER":
			account.setRoles(Arrays.asList(new Role("ROLE_EMPLOYER", LocalDateTime.now())));

			account = accountRepository.save(account);

			Employer employer = new Employer();

			employer.setAccountId(account.getId());
			employer.setCompanyName(registration.getCompanyName());
			employer.setSector(registration.getSector());

			employerService.save(employer);
			break;
		}

		return account;
	}

	@Override
	public Account save(UserDTO userDTO) {
		Account existing = null;

		if (userDTO.getId() != null) {
			existing = accountRepository.getOne(userDTO.getId());
		}

		Account account = AccountMapper.toAccount(existing, userDTO);
		if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty())
			account.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		account = accountRepository.save(account);

		if (userDTO.getRole() != null) {
			switch (userDTO.getRole()) {
			case "ROLE_JOBSEEKER":
				Jobseeker jobseeker = new Jobseeker();
				jobseeker.setAccount(new Account(account.getId()));

				jobseekerService.save(jobseeker);
				break;
			case "ROLE_EMPLOYER":
				Employer employer = new Employer();
				employer.setCompanyName(account.getName());
				employer.setAccountId(account.getId());

				employerService.save(employer);
				break;
			}
		}

		return account;
	}

	@Override
	public List<Account> getAllAccounts() {

		List<Account> accounts = accountRepository.findAll();

//		TODO: Remove Admin account
//		accounts.remove(0);

		return accounts;
	}

	@SuppressWarnings("serial")
	@Override
	public List<Account> searchAccounts(Account filter) {
		List<Account> accounts = accountRepository.findAll(new Specification<Account>() {

			@Override
			public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				// If id is specified in filter, add equal where clause
				if (filter.getId() != null) {
					predicates.add(cb.equal(root.get("id"), filter.getId()));
				}

				// If name is specified in filter, add equal where clause
				if (filter.getName() != null) {
					predicates.add(cb.like(cb.upper(root.get("name")), "%" + filter.getName().toUpperCase() + "%"));
				}

				// If email is specified in filter, add equal where clause
				if (filter.getEmail() != null) {
					predicates.add(cb.like(cb.upper(root.get("email")), "%" + filter.getEmail().toUpperCase() + "%"));
				}

				// If mobile phone is specified in filter, add equal where clause
				if (filter.getMobilePhone() != null) {
					predicates.add(cb.like(cb.upper(root.get("mobilePhone")),
							"%" + filter.getMobilePhone().toUpperCase() + "%"));
				}

				// If gender is specified in filter, add equal where clause
				if (filter.getGender() != null && !filter.getGender().isEmpty()
						&& !filter.getGender().trim().equals("")) {
					predicates.add(cb.like(cb.upper(root.get("gender")), "%" + filter.getGender().toUpperCase() + "%"));
				}

				// If city is specified in filter, add equal where clause
				if (filter.getCity() != null) {
					predicates.add(cb.equal(root.get("city").get("id"), filter.getCity().getId()));
				}

//				// If role is specified in filter, add equal where clause
//				if (filter.getRoles() != null) {
//					predicates.add((filter.getRoles()).containsAll((Collection<?>) root.get("roles")));
//				}

				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		return accounts;
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account savePassword(Account account, String password) {
		account.setPassword(passwordEncoder.encode(password));
		return accountRepository.save(account);
	}
}
