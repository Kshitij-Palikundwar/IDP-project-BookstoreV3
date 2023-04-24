package com.project.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
