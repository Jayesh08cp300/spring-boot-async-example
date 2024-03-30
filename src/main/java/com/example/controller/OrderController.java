package com.example.controller;

import com.example.dto.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping
	public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {
		service.processOrder(order); // synchronous

		// asynchronous
		service.notifyUser(order);
		service.assignVendor(order);
		service.packaging(order);
		service.assignDeliveryPartner(order);
		service.assignTrailerAndDispatch(order);

		return ResponseEntity.ok(order);
	}
}