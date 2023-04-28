package com.project.bookstore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer>{

	

	Optional<Cart> findCartByProductName(String productName);

}
