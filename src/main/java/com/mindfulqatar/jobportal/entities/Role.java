package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	@NotEmpty
	private String role;

	@Column(name = "created_on", columnDefinition = "CURRENT_TIMESTAMP", insertable = true, updatable = true)
	private LocalDateTime createdOn;

	// Notice that we use "roles" not the table name of "role". "roles" is from
	// Employer.roles.
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	private List<Account> accounts;

	protected Role() {
	}

	public Role(Long roleId) {
		this.id = roleId;
	}

	public Role(String role, LocalDateTime createdOn) {
		this.role = role;
		this.createdOn = createdOn;
	}

	// Getters and Setters
	// ===================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
