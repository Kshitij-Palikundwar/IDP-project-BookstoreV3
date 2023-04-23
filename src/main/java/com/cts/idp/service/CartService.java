package com.cts.idp.service;

import java.util.List;

import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.Cart;

public interface CartService {

	public Cart create(Cart cart);

	public List<Cart> findAll();

	public Cart findById(int id) throws ClassNotFoundException;

	public void deleteById(int id)throws ClassNotFoundException;
}
