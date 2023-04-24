package com.project.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookstore.model.Orders;
import com.project.bookstore.service.OrdersService;



@RestController
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private OrdersService service;
	
	/*
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Orders> findAll(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public Orders findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Orders create(@RequestBody Orders orders) {
		return service.create(orders);
	}
}
