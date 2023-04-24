package com.project.bookstore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

	Optional<Products> findProductsByProductName(String bookName);

}
