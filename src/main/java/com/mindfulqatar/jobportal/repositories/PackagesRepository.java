package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.Packages;

public interface PackagesRepository extends JpaRepository<Packages, Long> {
	List<Packages> findAll();
}
