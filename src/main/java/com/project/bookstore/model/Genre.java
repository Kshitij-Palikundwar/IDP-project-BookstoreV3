package com.project.bookstore.model;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "genres")
public class  Genre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	private int genreId;
	
	@Column(name = "genre_name")
	private String genreName;
	
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="genre_id")
//	private List<Products> products;

//	public Genre(String genreName, List<Products> products) {
//		super();
//		this.genreName = genreName;
//		this.products = products;
//	}
}