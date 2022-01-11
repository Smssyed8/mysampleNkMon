package com.mindfulqatar.jobportal.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Advertisement;
import com.mindfulqatar.jobportal.repositories.AdvertisementRepository;
import com.mindfulqatar.jobportal.services.AdvertisementService;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	AdvertisementRepository advertisementRepository;

	@Override
	public Advertisement save(Advertisement advertisement) {
		return advertisementRepository.save(advertisement);
	}

	@Override
	public Long countAdvertisements() {
		return advertisementRepository.count();
	}

	@SuppressWarnings("serial")
	@Override
	public List<Advertisement> searchAdvertisements(Advertisement filter) {
		List<Advertisement> advertisements = advertisementRepository.findAll(new Specification<Advertisement>() {

			@Override
			public Predicate toPredicate(Root<Advertisement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				// If id is specified in filter, add equal where clause
				if (filter.getId() != null) {
					predicates.add(cb.equal(root.get("id"), filter.getId()));
				}

				// If job title is specified in filter, add equal where clause
				if (filter.getTitle() != null) {
					predicates.add(
							cb.or(cb.like(cb.upper(root.get("title")), "%" + filter.getTitle().toUpperCase() + "%"),
									cb.like(cb.upper(root.get("text")), "%" + filter.getTitle().toUpperCase() + "%")));

				}

				// If button text is specified in filter, add equal where clause
				if (filter.getButtonText() != null) {
					predicates.add(cb.like(cb.upper(root.get("buttonText")),
							"%" + filter.getButtonText().toUpperCase() + "%"));
				}

				// If updatedOn is specified in filter, add equal where clause
				if (filter.getUpdatedOn() != null) {
					predicates.add(cb.equal(root.get("updatedOn"), filter.getUpdatedOn()));
				}

				// If createdOn is specified in filter, add equal where clause
				if (filter.getCreatedOn() != null) {
					predicates.add(cb.equal(root.get("createdOn"), filter.getCreatedOn()));
				}

				// If show is specified in filter, add equal where clause
				if (filter.getShow() != null) {
					predicates.add(cb.equal(root.get("show"), filter.getShow()));
				}

				// If payment done is specified in filter, add equal where clause
				if (filter.getPaymentDone() != null) {
					predicates.add(cb.equal(root.get("paymentDone"), filter.getPaymentDone()));
				}

				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		return advertisements;
	}

	@Override
	public void deleteAdvertisement(Long id) {
		advertisementRepository.deleteById(id);
	}

	@Override
	public Long getAdvertisementRevenue() {
		return advertisementRepository.getAdvertisementRevenue();
	}
}
