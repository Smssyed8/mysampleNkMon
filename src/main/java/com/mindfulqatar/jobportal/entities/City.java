package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "city")
public class City implements Comparable<City> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	@NotEmpty
	private String city;

	@ManyToOne()
	@JoinColumn(name = "country_id")
	private Country country;

	private String path;

	@Column(name = "created_on", columnDefinition = "CURRENT_TIMESTAMP", insertable = true, updatable = true)
	private LocalDateTime createdOn;

	protected City() {
	}

	public City(String city, LocalDateTime createdOn) {
		this.city = city;
		this.createdOn = createdOn;
	}

	public City(Long cityId) {
		this.id = cityId;
	}

	// Getters and Setters
	// ===================

	public Long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getPath() {
		return path;
	}

	public Country getCountry() {
		return country;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public int compareTo(City city) {
		return this.city.compareTo(city.city);
	}
}