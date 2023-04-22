package com.cts.idp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.idp.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
