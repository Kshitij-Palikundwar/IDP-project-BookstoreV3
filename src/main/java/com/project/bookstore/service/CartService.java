package com.project.bookstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.project.bookstore.model.Cart;



public interface CartService {
	public Cart create(Cart cart);
	
	public List<Cart> findAll();
	
	public Cart findById(int id);
	
	public void deleteById(int id);

	public Cart saveCart(Cart cart);
	
	//public void addToCart(int carId, CartItem cartItems);
	
	//public void addItemToCart(CartItem cartItem);

	//Cart createCartByProducts(String prodName);

//	ResponseEntity<String> createBill(Map<String, String> requestMap);
//
//	ResponseEntity<String> createCart(Map<String, String> requestMap);

}


