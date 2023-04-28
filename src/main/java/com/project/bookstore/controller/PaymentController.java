package com.project.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookstore.model.Payment;
import com.project.bookstore.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService service;
	
	/*
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Payment> findAll(){
		return service.findAll();
	}
	@GetMapping("/{paymentMethod}")
	public Payment findByPaymentMethod(@PathVariable("paymentMethod") String paymentMethod) {
		return service.findByPaymentMethod(paymentMethod);
	}
	
	@PostMapping
	public Payment create(@RequestBody Payment payment) {
		return service.create(payment);
	}
}
