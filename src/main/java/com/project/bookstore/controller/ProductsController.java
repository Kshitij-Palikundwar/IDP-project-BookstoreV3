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

import com.project.bookstore.model.Products;
import com.project.bookstore.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsService service;
	
	/*
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Products> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Products findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@GetMapping("/name/{productName}")
	public Products findProductsByProductsName(@PathVariable("productName") String productName) {
		return service.findProductsByProductName(productName);
	}
	
	@PostMapping
	public Products create(@RequestBody Products products) {
		return service.create(products);
	}
	
	@DeleteMapping("/{id}")	
	public void deleteById(@PathVariable("id") int id) {
		 service.deleteById(id);
	}

}

