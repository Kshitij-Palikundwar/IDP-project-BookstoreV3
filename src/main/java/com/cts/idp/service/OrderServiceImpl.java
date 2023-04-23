package com.cts.idp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.idp.dao.OrderRepository;
import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.Order;

@Service 
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;

	@Override
	public Order create(Order order) {
		
		return repo.save(order);
	}

	@Override
	public List<Order> findAll() {
		return repo.findAll();
	}

	@Override
	public Order findById(int id) throws ClassNotFoundException {
		Optional<Order> optional=repo.findById(id);
		if(optional.isEmpty()) {
			throw new ClassNotFoundException("Order Not Found of id: " + id);
		}
		return optional.get();
	}

	@Override
	public void deleteById(int id) throws ClassNotFoundException {
		Order order = findById(id);
		repo.deleteById(id);
		
	}

}
