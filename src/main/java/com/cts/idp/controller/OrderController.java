package com.cts.idp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.idp.model.Order;
import com.cts.idp.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	/**
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Order> findAll(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public Order findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	/**
	 * Used to create the resources
	 * @param order
	 * @return order
	 */
	@PostMapping
	public Order create(@RequestBody Order order) {
		return service.create(order);
	}
	
	
	@DeleteMapping("/{id}")	
	public void deleteById(@PathVariable("id") int id) {
		 service.deleteById(id);
	}
}
