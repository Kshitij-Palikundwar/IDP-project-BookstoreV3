package com.project.bookstore.service;

import java.util.List;

import com.project.bookstore.model.Genre;


public interface GenresService {
	public Genre create(Genre genre);
	
public List<Genre> findAll();
	
	public Genre findById(int id);

	//public void deleteById(int categoriesId);

}

