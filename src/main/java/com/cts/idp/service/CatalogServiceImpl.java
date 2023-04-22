package com.cts.idp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.idp.dao.CatalogRepository;
import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.Catalog;
import com.cts.idp.model.User;

@Service 
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogRepository repo;

	@Override
	public Catalog create(Catalog catalog) {
		
		return repo.save(catalog);
	}
	
	@Override
	public List<Catalog> showAll() {
		return repo.findAll();
	}

	@Override
	public Catalog findByBookName(String bookName) throws ClassNotFoundException {
		Optional<Catalog> optional=repo.findByBookName(bookName);
		if(optional.isEmpty()) {
			throw new ClassNotFoundException("Book Not Found Name: " + bookName);
		}
		return optional.get();
	}

	

}
