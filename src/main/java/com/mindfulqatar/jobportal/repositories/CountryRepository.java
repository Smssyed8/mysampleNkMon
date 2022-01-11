package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
	List<Country> findAll();
}
