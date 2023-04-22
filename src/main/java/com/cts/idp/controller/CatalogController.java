package com.cts.idp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.idp.model.Catalog;
import com.cts.idp.model.User;
import com.cts.idp.service.CatalogService;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {
	
	@Autowired
	private CatalogService service;
	
	/**
	 * Used to create the resources
	 * @param catalog
	 * @return catalog
	 */
	@PostMapping
	public Catalog create(@RequestBody Catalog catalog) {
		return service.create(catalog);
	}
	
	/**
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Catalog> findAll(){
		return service.showAll();
	}
	@GetMapping("/{name}")
	public Catalog findByBookName(@PathVariable("name") String bookName) {
		return service.findByBookName(bookName);
	}
	
	
	
}
