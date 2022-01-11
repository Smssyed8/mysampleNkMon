package com.mindfulqatar.jobportal.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Employer;
import com.mindfulqatar.jobportal.entities.Role;
import com.mindfulqatar.jobportal.repositories.AccountRepository;
import com.mindfulqatar.jobportal.repositories.EmployerRepository;
import com.mindfulqatar.jobportal.services.EmployerService;
import com.mindfulqatar.jobportal.dto.EmployerDTO;
import com.mindfulqatar.jobportal.entities.Account;

@Service
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	EmployerRepository employerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Employer getEmployerByEmail(String email) {
		Optional<Account> user = accountRepository.findByEmail(email);

		if (user.isPresent())
			return employerRepository.findByAccountId(user.get().getId());

		return null;
	}

	@Override
	public Account save(EmployerDTO registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employer save(Employer employer) {
		return employerRepository.save(employer);
	}

	@Override
	public long countEmployers() {
		return employerRepository.count();
	}

	@SuppressWarnings("serial")
	@Override
	public List<Employer> searchEmployers(Employer filter) {
		List<Employer> employers = employerRepository.findAll(new Specification<Employer>() {

			@Override
			public Predicate toPredicate(Root<Employer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				// If id is specified in filter, add equal where clause
				if (filter.getId() != null) {
					predicates.add(cb.equal(root.get("id"), filter.getId()));
				}

				// If company name is specified in filter, add equal where clause
				if (filter.getCompanyName() != null) {
					predicates.add(cb.like(cb.upper(root.get("companyName")),
							"%" + filter.getCompanyName().toUpperCase() + "%"));
				}

				// If company sector is specified in filter, add equal where clause
				if (filter.getSector() != null) {
					predicates.add(cb.equal(root.get("sector"), filter.getSector()));
				}

				// If company industry is specified in filter, add equal where clause
				if (filter.getCompanyIndustry() != null) {
					predicates.add(cb.equal(root.get("companyIndustry"), filter.getCompanyIndustry()));
				}

				// If company type is specified in filter, add equal where clause
				if (filter.getCompanyType() != null) {
					predicates.add(cb.equal(root.get("companyType"), filter.getCompanyType()));
				}

				// If package id is specified in filter, add equal where clause
				if (filter.getPackageId() != null) {
					predicates.add(cb.equal(root.get("packageId"), filter.getPackageId()));
				}

				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		return employers;
	}

	@Override
	public void deleteEmployer(Long id) {
		employerRepository.deleteById(id);
	}

	@Override
	public Boolean isValidEmployer(Long accountId) {
		Optional<Account> user = accountRepository.findById(accountId);

		if (user.isPresent())
			for (Role role : user.get().getRoles()) {
				if (role.getRole().equals("ROLE_EMPLOYER"))
					return true;
			}
		return false;
	}
}
