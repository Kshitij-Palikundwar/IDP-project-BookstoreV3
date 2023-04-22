package com.cts.idp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.idp.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

	Optional<Genre> findByGenreName(String genreName);

}
