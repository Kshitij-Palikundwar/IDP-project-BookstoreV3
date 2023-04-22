package com.cts.idp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.idp.model.Genre;
import com.cts.idp.service.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {
	
	@Autowired
	private GenreService service;
	
	/**
	 * Used to create the resources
	 * @param genre
	 * @return genre
	 */
	@PostMapping
	public Genre create(@RequestBody Genre genre) {
		return service.create(genre);
	}
	
	/**
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Genre> findAll(){
		return service.showAll();
	}
	@GetMapping("/{name}")
	public Genre findByGenreName(@PathVariable("name") String genreName) {
		return service.findByGenreName(genreName);
	}
	
	@DeleteMapping
	public List<Genre> deleteAll(){
		service.deleteAll();
		return null;
	}
}
