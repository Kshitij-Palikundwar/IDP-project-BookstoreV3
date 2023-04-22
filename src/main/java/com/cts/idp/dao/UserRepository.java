package com.cts.idp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.idp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
