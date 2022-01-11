package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "web_contact_us")
public class WebContactUs implements Comparable<WebContactUs> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String email;

	private String message;

	@Column(name = "created_on", columnDefinition = "CURRENT_TIMESTAMP", insertable = true, updatable = true)
	private LocalDateTime createdOn;

	protected WebContactUs() {
	}

	public WebContactUs(Long id) {
		this.id = id;
	}

	// Getters and Setters
	// ===================

	@Override
	public int compareTo(WebContactUs webContactUs) {
		return this.createdOn.compareTo(webContactUs.createdOn);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
}