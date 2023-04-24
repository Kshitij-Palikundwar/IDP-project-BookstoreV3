package com.project.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookstore.model.Cart;
import com.project.bookstore.service.CartService;


@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartService service;
	
	/*
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Cart> findAll(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public Cart findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Cart create(@RequestBody Cart cart) {
		return service.create(cart);
	}
	
	@DeleteMapping("/{id}")	
	public void deleteById(@PathVariable("id") int id) {
		 service.deleteById(id);
	}

}

