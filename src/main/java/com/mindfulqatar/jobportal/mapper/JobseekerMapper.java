package com.mindfulqatar.jobportal.mapper;

import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.Jobseeker;
import com.mindfulqatar.jobportal.dto.JobseekerDTO;
import com.mindfulqatar.jobportal.dto.JobseekerEditDTO;
import com.mindfulqatar.jobportal.dto.SearchJobseekersDTO;
import static com.mindfulqatar.jobportal.constants.Constant.JOBSEEKER_IMAGES_ROOT_FOLDER_PATH;
import static com.mindfulqatar.jobportal.constants.Constant.RESUMES_ROOT_FOLDER_PATH;

import static com.mindfulqatar.jobportal.constants.Constant.IMAGES_ROOT_FOLDER_PATH;

public class JobseekerMapper {

	public static Jobseeker toJobseeker(SearchJobseekersDTO jobseekerDTO) {
		Jobseeker jobseeker = new Jobseeker();

		if (jobseekerDTO.getId() != null) {
			jobseeker.setId(jobseekerDTO.getId());
		}

		if (jobseekerDTO.getCompanyName() != null) {
			jobseeker.setCompanyName(jobseekerDTO.getCompanyName());
		}

		if (jobseekerDTO.getCompanyIndustry() != null) {
			jobseeker.setCompanyIndustry(jobseekerDTO.getCompanyIndustry());
		}

		if (jobseekerDTO.getCompanySector() != null) {
			jobseeker.setSector(jobseekerDTO.getCompanySector());
		}

		return jobseeker;
	}

	public static Jobseeker toJobseeker(JobseekerDTO jobseekerDTO, Long sectorId) {
		Jobseeker jobseeker = new Jobseeker();

		jobseeker.setId(jobseekerDTO.getId());
		jobseeker.setCompanyName(jobseekerDTO.getCompanyName());
		jobseeker.setCompanyIndustry(jobseekerDTO.getCompanyIndustry());
		jobseeker.setAccount(new Account(jobseekerDTO.getAccountId()));
		jobseeker.setSector(sectorId);
		jobseeker.setWorkExperience(jobseekerDTO.getWorkExperience());
		jobseeker.setCompanySize(jobseekerDTO.getCompanySize());
		jobseeker.setCurrentSalary(jobseekerDTO.getCurrentSalary());
		jobseeker.setLanguagesKnown(jobseekerDTO.getLanguagesKnown());
		jobseeker.setHobbies(jobseekerDTO.getHobbies());
		jobseeker.setInterests(jobseekerDTO.getInterests());
		jobseeker.setSkills(jobseekerDTO.getSkills());
		jobseeker.setCareerLevel(jobseekerDTO.getCareerLevel());
		jobseeker.setJobRole(jobseekerDTO.getJobRole());
		jobseeker.setJobTitle(jobseekerDTO.getJobTitle());
		jobseeker.setDescJobLookingFor(jobseekerDTO.getDescJobLookingFor());
		jobseeker.setLinkedinProfile(jobseekerDTO.getLinkedinProfile());
		jobseeker.setFacebookProfile(jobseekerDTO.getFacebookProfile());
		jobseeker.setVideoProfile(jobseekerDTO.getVideoProfile());
		jobseeker.setExpectedSalary(jobseekerDTO.getExpectedSalary());
		jobseeker.setNoticePeriod(jobseekerDTO.getNoticePeriod());

		jobseeker.setImagePath(IMAGES_ROOT_FOLDER_PATH + JOBSEEKER_IMAGES_ROOT_FOLDER_PATH + "jobseeker_image_"
				+ jobseekerDTO.getAccountId().toString() + ".png");
		jobseeker.setResumePath(RESUMES_ROOT_FOLDER_PATH + "resume_" + jobseekerDTO.getAccountId().toString() + ".pdf");

		return jobseeker;
	}

	public static Jobseeker toJobseeker(Jobseeker currentJobseeker, JobseekerEditDTO jobseekerEditDTO, Long sectorId) {

		currentJobseeker.setCompanyName(jobseekerEditDTO.getCompanyName());
		currentJobseeker.setCompanyIndustry(jobseekerEditDTO.getCompanyIndustry());
		currentJobseeker.setSector(sectorId);
		currentJobseeker.setWorkExperience(jobseekerEditDTO.getWorkExperience());
		currentJobseeker.setCompanySize(jobseekerEditDTO.getCompanySize());
		currentJobseeker.setCurrentSalary(jobseekerEditDTO.getCurrentSalary());
		currentJobseeker.setLanguagesKnown(jobseekerEditDTO.getLanguagesKnown());
		currentJobseeker.setHobbies(jobseekerEditDTO.getHobbies());
		currentJobseeker.setInterests(jobseekerEditDTO.getInterests());
		currentJobseeker.setSkills(jobseekerEditDTO.getSkills());
		currentJobseeker.setCareerLevel(jobseekerEditDTO.getCareerLevel());
		currentJobseeker.setJobRole(jobseekerEditDTO.getJobRole());
		currentJobseeker.setJobTitle(jobseekerEditDTO.getJobTitle());
		currentJobseeker.setDescJobLookingFor(jobseekerEditDTO.getDescJobLookingFor());
		currentJobseeker.setLinkedinProfile(jobseekerEditDTO.getLinkedinProfile());
		currentJobseeker.setFacebookProfile(jobseekerEditDTO.getFacebookProfile());
		currentJobseeker.setVideoProfile(jobseekerEditDTO.getVideoProfile());
		currentJobseeker.setExpectedSalary(jobseekerEditDTO.getExpectedSalary());
		currentJobseeker.setNoticePeriod(jobseekerEditDTO.getNoticePeriod());

		currentJobseeker.setImagePath(IMAGES_ROOT_FOLDER_PATH + JOBSEEKER_IMAGES_ROOT_FOLDER_PATH + "jobseeker_image_"
				+ currentJobseeker.getAccount().getId().toString() + ".png");
		currentJobseeker.setResumePath(
				RESUMES_ROOT_FOLDER_PATH + "resume_" + currentJobseeker.getAccount().getId().toString() + ".pdf");

		return currentJobseeker;
	}
}
