package com.project.bookstore.service;

import java.util.List;


import com.project.bookstore.model.Orders;

public interface OrdersService {
	public Orders create(Orders orders);
	
public List<Orders> findAll();
	
	public Orders findById(int id);


}
