package com.cts.idp.service;

import java.util.List;

import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.Genre;

public interface GenreService {

	public List<Genre> showAll();

	public Genre create(Genre genre);

	Genre findByGenreName(String genreName) throws ClassNotFoundException;

	List<Genre> deleteAll();
}
