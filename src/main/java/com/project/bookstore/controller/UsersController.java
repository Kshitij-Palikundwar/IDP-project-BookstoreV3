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

import com.project.bookstore.model.Users;
import com.project.bookstore.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService service;
	
	/*
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Users> findAll(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public Users findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Users create(@RequestBody Users users) {
		return service.create(users);
	}
	
	@DeleteMapping("/{id}")	
	public void deleteById(@PathVariable("id") int id) {
		 service.deleteById(id);
	}

}



