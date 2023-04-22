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

import com.cts.idp.model.User;
import com.cts.idp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	/**
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<User> findAll(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	/**
	 * Used to create the resources
	 * @param user
	 * @return user
	 */
	@PostMapping
	public User create(@RequestBody User user) {
		return service.create(user);
	}
	
	
	@DeleteMapping("/{id}")	
	public void deleteById(@PathVariable("id") int id) {
		 service.deleteById(id);
	}
}
