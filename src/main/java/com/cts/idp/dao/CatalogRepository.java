package com.cts.idp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.idp.model.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, String> {

	
	//@Query("SELECT c FROM Catalog c WHERE c.bookName = :name")
    //Optional<Catalog> findByName(@Param("name") String name);

	Optional<Catalog> findByBookName(String bookName);
}
