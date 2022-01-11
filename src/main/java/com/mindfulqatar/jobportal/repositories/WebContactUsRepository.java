package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.WebContactUs;

public interface WebContactUsRepository extends JpaRepository<WebContactUs, Long> {
	List<WebContactUs> findAll();
}
