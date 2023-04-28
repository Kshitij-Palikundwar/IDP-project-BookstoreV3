package com.project.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookstore.model.Genre;
import com.project.bookstore.model.Products;
import com.project.bookstore.service.GenresService;
import com.project.bookstore.service.ProductsService;

import jakarta.transaction.SystemException;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsService service;
	
	@Autowired
	private GenresService genreService;
	
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
	
//	@PostMapping
//	public ResponseEntity<Products> create(@RequestBody Products product) {
//	    Products products = service.create(product); // persist the product
//	    return ResponseEntity.ok(products);
//	}
	@PostMapping
	public ResponseEntity<Products> create(@RequestBody Products product) throws ClassNotFoundException, SystemException {
	int genreId = product.getGenre().getGenreId();
	Genre genre = genreService.findById(genreId); // retrieve the genre from the database
	product.setGenre(genre); // associate the genre with the product
	Products savedProduct = service.create(product); // persist the product
	return ResponseEntity.ok(savedProduct);
	}

	
	@DeleteMapping("/{id}")	
	public void deleteById(@PathVariable("id") int id) {
		 service.deleteById(id);
	}

}

