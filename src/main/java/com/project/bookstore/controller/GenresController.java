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

import com.project.bookstore.model.Genre;
import com.project.bookstore.service.GenresService;

@RestController
@RequestMapping("/genres")
public class GenresController {
	@Autowired
	private GenresService service;
	
	/*
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Genre> findAll(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public Genre findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Genre create(@RequestBody Genre genre) {
		return service.create(genre);
	}
}
