package com.mindfulqatar.jobportal.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mindfulqatar.jobportal.enums.OrderStatusEnum;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "package_id")
	private Packages packages;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	private Long amount;
	private Long discount;

	@Column(name = "order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatusEnum orderStatus;

	@Column(name = "ordered_on", columnDefinition = "CURRENT_TIMESTAMP", updatable = false)
	private LocalDateTime orderedOn;

	@Column(name = "ordered_by")
	private Long orderedBy;

	@Transient
	private int orderedYear;

	@Transient
	private int orderedMonth;

	@Transient
	private int orderedDay;

	@Transient
	private String orderedStrMonth;

	@Transient
	private String orderedOnFormatted;

	public Orders() {
	}

	public Orders(Packages packages, Employer employer, Long amount, Long discount, OrderStatusEnum orderStatus,
			LocalDateTime orderedOn, Long orderedBy) {
		this.packages = packages;
		this.employer = employer;
		this.amount = amount;
		this.discount = discount;
		this.orderStatus = orderStatus;
		this.orderedOn = orderedOn;
		this.orderedBy = orderedBy;
	}

	@PrePersist
	private void onCreate() {
		setOrderedOn(LocalDateTime.now());
	}

	@PostLoad
	private void onLoad() {
		this.orderedYear = orderedOn.getYear();
		this.orderedMonth = orderedOn.getMonthValue();
		this.orderedDay = orderedOn.getDayOfMonth();
		this.orderedStrMonth = orderedOn.getMonth().toString();
		this.orderedOnFormatted = this.orderedStrMonth + " " + this.orderedDay + ", " + this.orderedYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOrderedOn() {
		return orderedOn;
	}

	public void setOrderedOn(LocalDateTime orderedOn) {
		this.orderedOn = orderedOn;
	}

	public Long getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(Long orderedBy) {
		this.orderedBy = orderedBy;
	}

	public String getOrderedOnFormatted() {
		return orderedOnFormatted;
	}

	public void setOrderedOnFormatted(String orderedOnFormatted) {
		this.orderedOnFormatted = orderedOnFormatted;
	}
}
