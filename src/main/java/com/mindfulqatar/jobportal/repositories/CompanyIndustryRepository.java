package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindfulqatar.jobportal.entities.CompanyIndustry;

public interface CompanyIndustryRepository extends JpaRepository<CompanyIndustry, Long> {
	List<CompanyIndustry> findBySectorId(Long sectorId);

	@Query("SELECT id FROM CompanyIndustry WHERE sectorId IN (:sectorIds)")
	List<Long> getCompanyIndustryIdsBySectorIds(@Param("sectorIds") List<Long> sectorIds);
}