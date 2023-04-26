package com.project.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

}
