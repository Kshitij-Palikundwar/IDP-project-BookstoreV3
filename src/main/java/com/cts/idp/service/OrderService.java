package com.cts.idp.service;

import java.util.List;

import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.Order;

public interface OrderService {

	public Order create(Order order);

	public List<Order> findAll();

	public Order findById(int id) throws ClassNotFoundException;

	public void deleteById(int id)throws ClassNotFoundException;
}
