package com.project.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
