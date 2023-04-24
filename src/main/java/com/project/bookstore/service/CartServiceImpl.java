package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.model.Cart;
import com.project.bookstore.dao.CartRepository;
import com.project.bookstore.exception.CartNotFoundException;


@Service
public class CartServiceImpl implements  CartService{
	
	@Autowired
	CartRepository repository;

	@Override
	public Cart create(Cart cart) {
		
		return repository.save(cart);
	}

	@Override
	public List<Cart> findAll() {

		return repository.findAll();
	}

	@Override
	public Cart findById(int id) {
		Optional<Cart> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new CartNotFoundException("Cart-Id not found with id :" + id);
		}
		
		return optional.get();
	}

	@Override
	public void deleteById(int id) throws CartNotFoundException {
		Cart cart = findById(id);
		repository.deleteById(id);
		
	}
	}


