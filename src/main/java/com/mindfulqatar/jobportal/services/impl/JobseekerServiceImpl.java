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

import com.mindfulqatar.jobportal.dto.SearchJobseekersDTO;
import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.Jobseeker;
import com.mindfulqatar.jobportal.entities.Role;
import com.mindfulqatar.jobportal.repositories.AccountRepository;
import com.mindfulqatar.jobportal.repositories.JobseekerRepository;
import com.mindfulqatar.jobportal.services.JobseekerService;

@Service
public class JobseekerServiceImpl implements JobseekerService {

	@Autowired
	JobseekerRepository jobseekerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Jobseeker getJobseekerByEmail(String email) {
		Optional<Account> user = accountRepository.findByEmail(email);

		if (user.isPresent())
			return jobseekerRepository.findByAccount(user.get());

		return null;
	}

	@Override
	public Jobseeker save(Jobseeker jobseeker) {
		return jobseekerRepository.save(jobseeker);
	}

	@Override
	public long countJobseekers() {
		return jobseekerRepository.count();
	}

	@SuppressWarnings("serial")
	@Override
	public List<Jobseeker> searchJobseekers(Jobseeker filter) {
		List<Jobseeker> jobseekers = jobseekerRepository.findAll(new Specification<Jobseeker>() {

			@Override
			public Predicate toPredicate(Root<Jobseeker> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				// If id is specified in filter, add equal where clause
				if (filter.getId() != null) {
					predicates.add(cb.equal(root.get("id"), filter.getId()));
				}

				// If company name is specified in filter, add equal where clause
				if (filter.getCompanyName() != null && !filter.getCompanyName().isEmpty()) {
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

				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		return jobseekers;
	}

	@SuppressWarnings("serial")
	@Override
	public List<Jobseeker> searchJobseekersWithExtraFilters(Jobseeker filter, SearchJobseekersDTO searchJobseekersDTO) {
		List<Jobseeker> jobseekers = jobseekerRepository.findAll(new Specification<Jobseeker>() {

			@Override
			public Predicate toPredicate(Root<Jobseeker> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				// If id is specified in filter, add equal where clause
				if (filter.getId() != null) {
					predicates.add(cb.equal(root.get("id"), filter.getId()));
				}

				// If company name is specified in filter, add equal where clause
				if (filter.getCompanyName() != null && !filter.getCompanyName().isEmpty()) {
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

				// If company name is specified in filter, add equal where clause
				if (searchJobseekersDTO.getKeywords() != null) {
					predicates.add(cb.or(
							cb.like(cb.upper(root.get("companyName")),
									"%" + searchJobseekersDTO.getKeywords().toUpperCase() + "%"),
							cb.like(cb.upper(root.get("skills")),
									"%" + searchJobseekersDTO.getKeywords().toUpperCase() + "%"),
							cb.like(cb.upper(root.get("descJobLookingFor")),
									"%" + searchJobseekersDTO.getKeywords().toUpperCase() + "%"),
							cb.like(cb.upper(root.get("jobTitle")),
									"%" + searchJobseekersDTO.getKeywords().toUpperCase() + "%"),
							cb.like(cb.upper(root.get("account").get("name")),
									"%" + searchJobseekersDTO.getKeywords().toUpperCase() + "%")));
				}

				if (searchJobseekersDTO.getMinExperience() != 0 || searchJobseekersDTO.getMaxExperience() != 0) {
					predicates.add(cb.and(cb.ge(root.get("workExperience"), searchJobseekersDTO.getMinExperience()),
							cb.le(root.get("workExperience"), searchJobseekersDTO.getMaxExperience())));
				}

				if (searchJobseekersDTO.getCityId() != null && searchJobseekersDTO.getCityId() != 0) {
					predicates.add(cb.ge(root.get("account").get("city").get("id"), searchJobseekersDTO.getCityId()));
				}

				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		return jobseekers;
	}

	@Override
	public void deleteJobseeker(Long id) {
		jobseekerRepository.deleteById(id);
	}

	@Override
	public Boolean isValidJobseeker(Long accountId) {
		Optional<Account> user = accountRepository.findById(accountId);

		if (user.isPresent())
			for (Role role : user.get().getRoles()) {
				if (role.getRole().equals("ROLE_JOBSEEKER"))
					return true;
			}
		return false;
	}

	@Override
	public List<Jobseeker> getAllJobseekers() {
		return jobseekerRepository.findAll();
	}
}
