package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotNull
	private String name;

	@Column(nullable = false, unique = true)
	@NotNull
	private String username;

	@Column(nullable = false, unique = true)
	@NotNull
	@Email(message = "{errors.invalid_email}")
	private String email;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "account_role_map", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;

	@NotNull
	@Pattern(regexp = "(^$|[0-9]{8})")
	@Column(name = "mobile_phone")
	private String mobilePhone;

	@NotNull
	@Size(min = 2, max = 256)
	private String password;
	private String gender;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "nationality")
	private Country nationality;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "no_of_dependants")
	private int numberOfDependents;

	private LocalDateTime dob;

	@Column(name = "tel_no")
	private String telNo;

	@Column(name = "rp_no")
	private String rpNo;

	@Column(name = "passport_no")
	private String passportNo;

	@Column(name = "rp_validity")
	private String rpValidity;

	private String sponsor;

	private String status;

	@Column(name = "passport_validity")
	private String passportValidity;

	private boolean enabled;
	private boolean expired;
	private boolean locked;

	@Column(name = "credentials_expired")
	private boolean credentialsExpired;

	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	@Column(name = "created_on", columnDefinition = "CURRENT_TIMESTAMP", updatable = false)
	private LocalDateTime createdOn;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@Column(name = "updated_by")
	private Long updatedBy;

	private boolean approved;

	private boolean x;

	@Transient
	private int lastLoginYear;

	@Transient
	private int lastLoginDay;

	@Transient
	private String lastLoginMonth;

	@Transient
	private String lastLoginTime;

	@Transient
	private String lastLoginFormatted;

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

	public Account() {
	}

	public Account(long accountId) {
		this.id = accountId;
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

		if (lastLogin != null) {
			this.lastLoginYear = lastLogin.getYear();
			this.lastLoginDay = lastLogin.getDayOfMonth();
			this.lastLoginMonth = lastLogin.getMonth().toString();
			this.lastLoginTime = lastLogin.getHour() + ":" + lastLogin.getMinute() + ":" + lastLogin.getSecond();
			this.lastLoginFormatted = this.lastLoginMonth + " " + this.lastLoginDay + ", " + this.lastLoginYear + " at "
					+ lastLoginTime;
		}
	}

	// Getters and Setters
	// ===================
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getRpNo() {
		return rpNo;
	}

	public void setRpNo(String rpNo) {
		this.rpNo = rpNo;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getRpValidity() {
		return rpValidity;
	}

	public void setRpValidity(String rpValidity) {
		this.rpValidity = rpValidity;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassportValidity() {
		return passportValidity;
	}

	public void setPassportValidity(String passportValidity) {
		this.passportValidity = passportValidity;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean getExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean getLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean getCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean getApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean getX() {
		return x;
	}

	public void setX(boolean x) {
		this.x = x;
	}

	public int getLastLoginYear() {
		return lastLoginYear;
	}

	public void setLastLoginYear(int lastLoginYear) {
		this.lastLoginYear = lastLoginYear;
	}

	public int getLastLoginDay() {
		return lastLoginDay;
	}

	public void setLastLoginDay(int lastLoginDay) {
		this.lastLoginDay = lastLoginDay;
	}

	public String getLastLoginMonth() {
		return lastLoginMonth;
	}

	public void setLastLoginMonth(String lastLoginMonth) {
		this.lastLoginMonth = lastLoginMonth;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginFormatted() {
		return lastLoginFormatted;
	}

	public void setLastLoginFormatted(String lastLoginFormatted) {
		this.lastLoginFormatted = lastLoginFormatted;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setNumberOfDependents(int numberOfDependents) {
		this.numberOfDependents = numberOfDependents;
	}

	public int getNumberOfDependents() {
		return numberOfDependents;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", roles="
				+ roles + ", mobilePhone=" + mobilePhone + ", password=" + password + ", gender=" + gender + ", city="
				+ city.getCity() + ", nationality=" + nationality.getCountry() + ", maritalStatus=" + maritalStatus
				+ ", numberOfDependents=" + numberOfDependents + ", dob=" + dob + ", telNo=" + telNo + ", rpNo=" + rpNo
				+ ", passportNo=" + passportNo + ", rpValidity=" + rpValidity + ", sponsor=" + sponsor + ", status="
				+ status + ", passportValidity=" + passportValidity + ", enabled=" + enabled + ", expired=" + expired
				+ ", locked=" + locked + ", credentialsExpired=" + credentialsExpired + ", lastLogin=" + lastLogin
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn + ", updatedBy="
				+ updatedBy + ", approved=" + approved + ", x=" + x + ", lastLoginYear=" + lastLoginYear
				+ ", lastLoginDay=" + lastLoginDay + ", lastLoginMonth=" + lastLoginMonth + ", lastLoginTime="
				+ lastLoginTime + ", lastLoginFormatted=" + lastLoginFormatted + ", createdYear=" + createdYear
				+ ", createdMonth=" + createdMonth + ", createdDay=" + createdDay + ", createdStrMonth="
				+ createdStrMonth + ", createdOnFormatted=" + createdOnFormatted + "]";
	}
}
