package com.project.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.Genre;

public interface GenresRepository extends JpaRepository<Genre, Integer>{

}
