package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.model.Users;
import com.project.bookstore.dao.UsersRepository;
import com.project.bookstore.exception.UsersNotFoundException;


@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository repository;

	@Override
	public Users create(Users users) {
		
		return repository.save(users);
	}

	@Override
	public List<Users> findAll() {
		return repository.findAll();
	}

	@Override
	public Users findById(int id) {
		Optional<Users> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new UsersNotFoundException("Customer not found with id :" + id);
		}
		
		return optional.get();
	}

	@Override
	public void deleteById(int customersId) throws UsersNotFoundException {
		Users customer = findById(customersId);
		repository.deleteById(customersId);
		
	}

}


