package com.mindfulqatar.jobportal.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Country;
import com.mindfulqatar.jobportal.repositories.CountryRepository;
import com.mindfulqatar.jobportal.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country getCountryById(Long countryId) {
		Optional<Country> country = countryRepository.findById(countryId);

		if (country.isPresent()) {
			return country.get();
		}
		return null;
	}
}
