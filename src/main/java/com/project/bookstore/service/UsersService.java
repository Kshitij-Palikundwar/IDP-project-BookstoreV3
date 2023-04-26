package com.project.bookstore.service;

import java.util.List;

import com.project.bookstore.model.User;

public interface UsersService {
	public User create(User user);

	public List<User> findAll();

	public User findById(int id);

	public void deleteById(int customersId);
}
