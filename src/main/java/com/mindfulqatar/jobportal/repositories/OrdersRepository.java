package com.mindfulqatar.jobportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.mindfulqatar.jobportal.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>, JpaSpecificationExecutor<Orders> {
	List<Orders> findAll();

	@Query(value = "SELECT SUM(amount) FROM orders WHERE order_status='PAID'", nativeQuery = true)
	Long getEmployersRevenue();
}
