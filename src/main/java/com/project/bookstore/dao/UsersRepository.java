package com.project.bookstore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String name);

}
