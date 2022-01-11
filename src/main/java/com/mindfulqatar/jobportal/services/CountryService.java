package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.Country;

public interface CountryService {
	List<Country> getAllCountries();

	Country getCountryById(Long countryId);
}