package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Sector;
import com.mindfulqatar.jobportal.repositories.SectorRepository;
import com.mindfulqatar.jobportal.services.SectorService;

@Service
public class SectorServiceImpl implements SectorService {

	@Autowired
	SectorRepository sectorRepository;

	@Override
	public Sector save(Sector sector) {
		return sectorRepository.save(sector);
	}

	@Override
	public List<Sector> getAllSectors() {
		return sectorRepository.findAll();
	}
}
