package com.mindfulqatar.jobportal.mapper;

import com.mindfulqatar.jobportal.entities.Employer;
import com.mindfulqatar.jobportal.dto.EmployerDTO;
import com.mindfulqatar.jobportal.dto.EmployerEditDTO;
import com.mindfulqatar.jobportal.dto.SearchEmployersDTO;
import static com.mindfulqatar.jobportal.constants.Constant.COMPANY_IMAGES_ROOT_FOLDER_PATH;
import static com.mindfulqatar.jobportal.constants.Constant.IMAGES_ROOT_FOLDER_PATH;

public class EmployerMapper {

	public static Employer toEmployer(SearchEmployersDTO employerDTO) {
		Employer employer = new Employer();

		if (employerDTO.getId() != null) {
			employer.setId(employerDTO.getId());
		}

		if (employerDTO.getCompanyName() != null) {
			employer.setCompanyName(employerDTO.getCompanyName());
		}

		if (employerDTO.getCompanyIndustry() != null) {
			employer.setCompanyIndustry(employerDTO.getCompanyIndustry());
		}

		if (employerDTO.getCompanySector() != null) {
			employer.setSector(employerDTO.getCompanySector());
		}

		if (employerDTO.getCompanyType() != null) {
			employer.setCompanyType(employerDTO.getCompanyType());
		}

		if (employerDTO.getCompanyPackage() != null) {
			employer.setPackageId(employerDTO.getCompanyPackage());
		}

		return employer;
	}

	public static Employer toEmployer(EmployerDTO employerDTO, Long sectorId) {
		Employer employer = new Employer();

		employer.setId(employerDTO.getId());
		employer.setCompanyName(employerDTO.getCompanyName());
		employer.setCompanyIndustry(employerDTO.getCompanyIndustry());
		employer.setSector(sectorId);
		employer.setCompanyType(employerDTO.getCompanyType());
		employer.setPackageId(employerDTO.getPackageId());
		employer.setCrnNumber(employerDTO.getCrnNumber());
		employer.setTaxRegistrationNumber(employerDTO.getTaxRegistrationNumber());
		employer.setAccountId(employerDTO.getAccountId());
		employer.setAddress(employerDTO.getAddress());
		employer.setDesignation(employerDTO.getDesignation());

		employer.setImagePath(IMAGES_ROOT_FOLDER_PATH + COMPANY_IMAGES_ROOT_FOLDER_PATH + "company_image_"
				+ employerDTO.getAccountId().toString() + ".png");

		return employer;
	}

	public static Employer toEmployer(Employer currentEmployer, EmployerEditDTO employerEditDTO, Long sectorId) {
		currentEmployer.setCompanyName(employerEditDTO.getCompanyName());
		currentEmployer.setCompanyIndustry(employerEditDTO.getCompanyIndustry());
		currentEmployer.setSector(sectorId);
		currentEmployer.setCompanyType(employerEditDTO.getCompanyType());
		currentEmployer.setCrnNumber(employerEditDTO.getCrnNumber());
		currentEmployer.setTaxRegistrationNumber(employerEditDTO.getTaxRegistrationNumber());
		currentEmployer.setAddress(employerEditDTO.getAddress());
		currentEmployer.setDesignation(employerEditDTO.getDesignation());

		currentEmployer.setImagePath(IMAGES_ROOT_FOLDER_PATH + COMPANY_IMAGES_ROOT_FOLDER_PATH + "company_image_"
				+ currentEmployer.getAccountId().toString() + ".png");

		return currentEmployer;
	}
}
