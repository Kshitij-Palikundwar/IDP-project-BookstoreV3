package com.cts.idp.model;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "genre_tbl")
public class Genre {
	

	@Id
	@Column(name = "genre_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int genreId;
	
	@Column(name = "genre_name")
	private String genreName;
	
	// Here we are mapping genre with catalog table 
	// Where 1 genre has Many books/products
	@OneToMany(mappedBy="genre")
	private List<Catalog> catalog = new ArrayList<>();


	

	public Genre(String genreName, List<Catalog> catalog) {
		super();
		this.genreName = genreName;
		this.catalog = catalog;
	}
	


}
