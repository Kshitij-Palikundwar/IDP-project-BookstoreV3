package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.model.Genre;
import com.project.bookstore.dao.GenresRepository;
import com.project.bookstore.exception.GenresNotFoundException;



@Service
public class GenresServiceImpl implements GenresService{
	
	@Autowired
	GenresRepository repository;

	@Override
	public Genre create(Genre genre) {
		
		return repository.save(genre);
	}

	@Override
	public List<Genre> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Genre findById(int id) {
		Optional<Genre> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new GenresNotFoundException("Category not found with id :" + id);
		}
		
		return optional.get();
	}
}
