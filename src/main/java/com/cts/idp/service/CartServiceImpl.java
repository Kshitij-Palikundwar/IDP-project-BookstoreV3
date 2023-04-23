package com.cts.idp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.idp.dao.CartRepository;
import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.Cart;

@Service 
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository repo;

	@Override
	public Cart create(Cart cart) {
		
		return repo.save(cart);
	}

	@Override
	public List<Cart> findAll() {
		return repo.findAll();
	}

	@Override
	public Cart findById(int id) throws ClassNotFoundException {
		Optional<Cart> optional=repo.findById(id);
		if(optional.isEmpty()) {
			throw new ClassNotFoundException("Cart Not Found of id: " + id);
		}
		return optional.get();
	}

	@Override
	public void deleteById(int id) throws ClassNotFoundException {
		Cart cart = findById(id);
		repo.deleteById(id);
		
	}

}
