package com.cts.idp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.idp.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
