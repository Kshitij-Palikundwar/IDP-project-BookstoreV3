package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.model.Products;
import com.project.bookstore.dao.ProductsRepository;
import com.project.bookstore.exception.ProductsNotFoundException;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	ProductsRepository repository;

	@Override
	public Products create(Products products) {
	
		return repository.save(products);
	}

	@Override
	public List<Products> findAll() {

		return repository.findAll();
	}

	@Override
	public Products findById(int id) {
		Optional<Products> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new ProductsNotFoundException("Products not found with id :" + id);
		}
		
		return optional.get();
	}

	@Override
	public void deleteById(int id) {
		Products products= findById(id);
		repository.deleteById(id);
		
	}

	@Override
	public Products findProductsByProductName(String productName) {
		Optional<Products> optional = repository.findProductsByProductName(productName);
		if(optional.isEmpty()) {
			throw new ProductsNotFoundException("Book not found with Name :" + productName);
		}		
		return optional.get();
	}
	

}


