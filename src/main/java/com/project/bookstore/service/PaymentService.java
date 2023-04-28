package com.project.bookstore.service;

import java.util.List;


import com.project.bookstore.model.Payment;

public interface PaymentService {
	public Payment create(Payment payment);
	
	public List<Payment> findAll();
	
	public Payment findByPaymentMethod(String paymentMethod);

}
