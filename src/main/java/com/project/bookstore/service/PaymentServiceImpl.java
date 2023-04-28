package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.model.Payment;
import com.project.bookstore.dao.PaymentRepository;
import com.project.bookstore.exception.PaymentNotFoundException;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentRepository repository;

	@Override
	public Payment create(Payment payment) {
		// TODO Auto-generated method stub
		return repository.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

//	@Override
//	public Payment findById(int id) {
//		Optional<Payment> optional = repository.findById(id);
//		if(optional.isEmpty()) {
//			throw new PaymentNotFoundException("Payment not found with id :" + id);
//		}		
//		return optional.get();
//	}

	@Override
	public Payment findByPaymentMethod(String paymentMethod) {
		Optional<Payment> optional = repository.findByPaymentMethod(paymentMethod);
		if(optional.isEmpty()) {
			throw new PaymentNotFoundException("Payment Method not found :" + paymentMethod);
		}		
		return optional.get();
	}

}
