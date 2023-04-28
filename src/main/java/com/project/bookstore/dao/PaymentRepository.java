package com.project.bookstore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	Optional<Payment> findByPaymentMethod(String paymentMethod);

}
