package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long> {
	List<Sector> findAll();
}