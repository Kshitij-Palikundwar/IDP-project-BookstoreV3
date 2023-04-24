package com.project.bookstore.service;

import java.util.List;


import com.project.bookstore.model.Products;

public interface ProductsService {
	public Products create(Products products);

	public List<Products> findAll();
	
	public Products findById(int productsId);

	public void deleteById(int productsId);
	
	public Products findProductsByProductName(String bookName);
}


