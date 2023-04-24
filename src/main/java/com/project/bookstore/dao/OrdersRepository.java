package com.project.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
