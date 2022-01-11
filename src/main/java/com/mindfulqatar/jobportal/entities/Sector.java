package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sector")
public class Sector implements Comparable<Sector> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sector")
	private String sector;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sectorId")
	List<CompanyIndustry> companyIndustries;

	@Column(name = "created_on", columnDefinition = "CURRENT_TIMESTAMP", updatable = false)
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@Column(name = "updated_by")
	private Long updatedBy;

	@Transient
	private int createdYear;

	@Transient
	private int createdMonth;

	@Transient
	private int createdDay;

	@Transient
	private String createdStrMonth;

	@Transient
	private String createdOnFormatted;

	public Sector() {
	}

	@PrePersist
	private void onCreate() {
		setCreatedOn(LocalDateTime.now());
	}

	@PostLoad
	private void onLoad() {
		this.createdYear = createdOn.getYear();
		this.createdMonth = createdOn.getMonthValue();
		this.createdDay = createdOn.getDayOfMonth();
		this.createdStrMonth = createdOn.getMonth().toString();
		this.createdOnFormatted = this.createdStrMonth + " " + this.createdDay + ", " + this.createdYear;
	}

	// Getters and Setters
	// ===================

	public Long getId() {
		return id;
	}

	public String getSector() {
		return sector;
	}

	public List<CompanyIndustry> getCompanyIndustries() {
		return companyIndustries;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public int getCreatedYear() {
		return createdYear;
	}

	public int getCreatedMonth() {
		return createdMonth;
	}

	public int getCreatedDay() {
		return createdDay;
	}

	public String getCreatedStrMonth() {
		return createdStrMonth;
	}

	public String getCreatedOnFormatted() {
		return createdOnFormatted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public void setCompanyIndustries(List<CompanyIndustry> companyIndustries) {
		this.companyIndustries = companyIndustries;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setCreatedYear(int createdYear) {
		this.createdYear = createdYear;
	}

	public void setCreatedMonth(int createdMonth) {
		this.createdMonth = createdMonth;
	}

	public void setCreatedDay(int createdDay) {
		this.createdDay = createdDay;
	}

	public void setCreatedStrMonth(String createdStrMonth) {
		this.createdStrMonth = createdStrMonth;
	}

	public void setCreatedOnFormatted(String createdOnFormatted) {
		this.createdOnFormatted = createdOnFormatted;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", sector=" + sector + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", updatedBy=" + updatedBy + ", createdOnFormatted=" + createdOnFormatted + "]";
	}

	@Override
	public int compareTo(Sector sector) {
		return this.sector.compareTo(sector.sector);
	}
}
