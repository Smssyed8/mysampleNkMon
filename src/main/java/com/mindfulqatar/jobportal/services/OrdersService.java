package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.Orders;

public interface OrdersService {

	List<Orders> getAllOrders();

	Orders save(Orders orders);

	List<Orders> searchOrders(Orders orders);

	Orders getOrderById(Long orderId);

	Long getEmployersRevenue();

}
