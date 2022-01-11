package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.Sector;

public interface SectorService {
	List<Sector> getAllSectors();

	Sector save(Sector sector);
}