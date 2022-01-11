package com.mindfulqatar.jobportal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.mindfulqatar.jobportal.entities.Advertisement;

public interface AdvertisementRepository
		extends JpaRepository<Advertisement, Long>, JpaSpecificationExecutor<Advertisement> {
	Optional<Advertisement> findById(Long id);

	@Query("SELECT SUM(price) FROM Advertisement WHERE paymentDone=true")
	Long getAdvertisementRevenue();

	long count();
}
