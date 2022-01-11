package com.mindfulqatar.jobportal.dto;

public class SearchJobseekerJobMapDTO {

	private Long id;
	private Long jobId;
	private Long jobseekerId;
	private Boolean shortlisted;

	// Getters and Setters
	// ===================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getJobseekerId() {
		return jobseekerId;
	}

	public void setJobseekerId(Long jobseekerId) {
		this.jobseekerId = jobseekerId;
	}

	public Boolean getShortlisted() {
		return shortlisted;
	}

	public void setShortlisted(Boolean shortlisted) {
		this.shortlisted = shortlisted;
	}
}