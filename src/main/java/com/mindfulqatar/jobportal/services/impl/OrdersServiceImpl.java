package com.mindfulqatar.jobportal.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Orders;
import com.mindfulqatar.jobportal.services.OrdersService;
import com.mindfulqatar.jobportal.repositories.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> orders = ordersRepository.findAll();

		return orders;
	}

	@SuppressWarnings("serial")
	@Override
	public List<Orders> searchOrders(Orders filter) {
		List<Orders> orders = ordersRepository.findAll(new Specification<Orders>() {

			@Override
			public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				// If id is specified in filter, add equal where clause
				if (filter.getId() != null) {
					predicates.add(cb.equal(root.get("id"), filter.getId()));
				}

				// If package is specified in filter, add equal where clause
				if (filter.getPackages() != null) {
					predicates.add(cb.equal(root.get("packages").get("id"), filter.getPackages().getId()));
				}

				// If employer is specified in filter, add equal where clause
				if (filter.getEmployer() != null) {
					predicates.add(cb.equal(root.get("employer").get("id"), filter.getEmployer().getId()));
				}

				// If orderStatus is specified in filter, add equal where clause
				if (filter.getOrderStatus() != null) {
					predicates.add(cb.equal(root.get("orderStatus"), filter.getOrderStatus()));
				}

				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		return orders;
	}

	@Override
	public Orders save(Orders orders) {
		return ordersRepository.save(orders);
	}

	@Override
	public Orders getOrderById(Long orderId) {
		Optional<Orders> order = ordersRepository.findById(orderId);

		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

	@Override
	public Long getEmployersRevenue() {
		return ordersRepository.getEmployersRevenue();
	}
}
