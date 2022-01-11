package com.mindfulqatar.jobportal.services;

import com.mindfulqatar.jobportal.entities.Advertisement;

import java.util.List;

public interface AdvertisementService {
	List<Advertisement> searchAdvertisements(Advertisement advertisement);

	Advertisement save(Advertisement advertisement);

	Long countAdvertisements();

	void deleteAdvertisement(Long id);

	Long getAdvertisementRevenue();
}
