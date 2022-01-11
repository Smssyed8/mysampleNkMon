package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employer_contact_us")
public class EmployerContactUs implements Comparable<EmployerContactUs> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String subject;

	@NotEmpty
	private String name;

	@NotEmpty
	@Email(message = "{errors.invalid_email}")
	private String email;

	@NotEmpty
	private String message;

	@NotEmpty
	@Column(name = "job_title")
	private String jobTitle;

	@NotEmpty
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "country_id")
	@NotNull
	private Long countryId;

	@NotEmpty
	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "employer_id")
	@NotNull
	private Long employerId;

	@Column(name = "created_on", columnDefinition = "CURRENT_TIMESTAMP", insertable = true, updatable = true)
	private LocalDateTime createdOn;

	public EmployerContactUs() {
	}

	public EmployerContactUs(Long id) {
		this.id = id;
	}

	// Getters and Setters
	// ===================

	@Override
	public int compareTo(EmployerContactUs webContactUs) {
		return this.createdOn.compareTo(webContactUs.createdOn);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
}