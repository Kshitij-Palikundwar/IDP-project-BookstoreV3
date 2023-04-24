package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.model.Orders;
import com.project.bookstore.dao.OrdersRepository;
import com.project.bookstore.exception.OrdersNotFoundException;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrdersRepository repository;

	@Override
	public Orders create(Orders orders) {
		
		return repository.save(orders);
	}

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Orders findById(int id) {
		Optional<Orders> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new OrdersNotFoundException("Order not found with id :" + id);
		}
		
		return optional.get();
	}

}
