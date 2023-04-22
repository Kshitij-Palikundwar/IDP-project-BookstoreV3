package com.cts.idp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.idp.dao.GenreRepository;
import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.Genre;


@Service 
public class GrenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository repo;

	@Override
	public Genre create(Genre genre) {
		
		return repo.save(genre);
	}
	
	@Override
	public List<Genre> showAll() {
		return repo.findAll();
	}

	@Override
	public Genre findByGenreName(String genreName) throws ClassNotFoundException {
		Optional<Genre> optional=repo.findByGenreName(genreName);
		if(optional.isEmpty()) {
			throw new ClassNotFoundException("Genre Not Found Name: " + genreName);
		}
		return optional.get();
	}
	
	@Override
	public List<Genre> deleteAll(){
		repo.deleteAll();
		return null;
	}

}
