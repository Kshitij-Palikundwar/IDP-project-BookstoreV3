package com.cts.idp.service;

import java.util.List;

import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.Catalog;

public interface CatalogService {

	public List<Catalog> showAll();

	public Catalog findByBookName(String bookName) throws ClassNotFoundException;

	public Catalog create(Catalog catalog);
}
