package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.model.User;
import com.project.bookstore.dao.UsersRepository;
import com.project.bookstore.exception.UsersNotFoundException;


@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository repository;

	@Override
	public User create(User user) {
		
		return repository.save(user);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new UsersNotFoundException("Customer not found with id :" + id);
		}
		
		return optional.get();
	}

	@Override
	public void deleteById(int customersId) throws UsersNotFoundException {
		User customer = findById(customersId);
		repository.deleteById(customersId);
		
	}

	@Override
	public User findByName(String name) {
		Optional<User> optional = repository.findByName(name);
		if(optional.isEmpty()) {
			throw new UsersNotFoundException("Customer not found with id :" + name);
		}
		
		return optional.get();
	}

}


