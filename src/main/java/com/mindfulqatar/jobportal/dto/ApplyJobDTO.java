package com.mindfulqatar.jobportal.dto;

public class ApplyJobDTO {
	private Long jobId;
	private String appliedJob;

	// Getters and Setters
	// ===================

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getAppliedJob() {
		return appliedJob;
	}

	public void setAppliedJob(String appliedJob) {
		this.appliedJob = appliedJob;
	}
}
