package com.mindfulqatar.jobportal.mapper;

import com.mindfulqatar.jobportal.entities.Employer;
import com.mindfulqatar.jobportal.entities.Orders;
import com.mindfulqatar.jobportal.entities.Packages;
import com.mindfulqatar.jobportal.enums.OrderStatusEnum;
import com.mindfulqatar.jobportal.dto.SearchOrdersDTO;

public class OrdersMapper {

	public static Orders toOrder(SearchOrdersDTO orderDTO) {
		Orders order = new Orders();

		if (orderDTO.getId() != null) {
			order.setId(orderDTO.getId());
		}

		if (orderDTO.getPackageId() != null) {
			order.setPackages(new Packages(orderDTO.getPackageId()));
		}

		if (orderDTO.getEmployerId() != null) {
			order.setEmployer(new Employer(orderDTO.getEmployerId()));
		}

		if (orderDTO.getOrderStatus() != null && !orderDTO.getOrderStatus().isEmpty()) {
			order.setOrderStatus(OrderStatusEnum.getByValue(orderDTO.getOrderStatus()));
		}

		return order;
	}
}
