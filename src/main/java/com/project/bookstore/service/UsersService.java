package com.project.bookstore.service;

import java.util.List;

import com.project.bookstore.model.Users;

public interface UsersService {
	public Users create(Users users);

	public List<Users> findAll();

	public Users findById(int id);

	public void deleteById(int customersId);
}
