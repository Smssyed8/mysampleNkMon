package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findAll();
}
