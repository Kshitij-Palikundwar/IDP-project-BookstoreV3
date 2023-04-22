package com.cts.idp.model;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book_catalog")
public class Catalog {
	
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "author")
	private String bookAuthor;
	
	@Column(name = "description")
	private String bookDescription;
	
	@Column(name = "price")
	private double bookPrice;



	@ManyToOne
	@JoinColumn(name="genre_id")
	private Genre genre;

	@OneToMany(mappedBy = "catalog")
	private List<Cart> cart = new ArrayList<>();


	public Catalog(String bookName, String bookAuthor, String bookDescription, double bookPrice, Genre genre) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
		this.genre = genre;
	}



	public Catalog(String bookName, String bookAuthor, String bookDescription, float bookPrice) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
	}
	

	


}
