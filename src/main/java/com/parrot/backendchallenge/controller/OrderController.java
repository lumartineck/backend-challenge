package com.parrot.backendchallenge.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parrot.backendchallenge.dao.OrderRepository;
import com.parrot.backendchallenge.dao.UserRepository;
import com.parrot.backendchallenge.model.Order;
import com.parrot.backendchallenge.model.User;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<Order> findAllOrders() {
		return (List<Order>) orderRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable(value = "id") long id) {
		Optional<Order> order = orderRepository.findById(id);

		if (order.isPresent()) {
			return ResponseEntity.ok().body(order.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Order saveOrder(@Validated @RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	@GetMapping("/user/{id}")
	public List<Order> findOrdersByUserId(@PathVariable(value = "id") long id) {
		Optional<User> user = userRepository.findById(id);
		System.out.println(">>>>>>>>>>");
		System.out.println(user);
		return user.isPresent() ? user.get().getOrders() : Collections.emptyList();
	}
}
