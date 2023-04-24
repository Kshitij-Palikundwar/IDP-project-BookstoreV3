package com.project.bookstore.service;

import java.util.List;

import com.project.bookstore.model.Cart;


public interface CartService {
	public Cart create(Cart cart);
	
public List<Cart> findAll();
	
	public Cart findById(int id);
	
	public void deleteById(int id);

}


