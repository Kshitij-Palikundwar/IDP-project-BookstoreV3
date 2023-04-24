package com.project.bookstore.model;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Products implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_author")
	private String productAuthor;
	
	@Column(name="product_desc")
	private String productDesc;
	
	@Column(name="net_price")
	private float cost;
	@Column(name="product_quantity")
	private int quantity;
	
	@Column(name="product_image")
	private String productImage;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name = "cart_id",  referencedColumnName = "id")
//	private List<Cart> cart;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "genre_id", referencedColumnName = "id")
	private Genre genre;

	public Products(String productName, String productDesc, float cost, String productImage,int quantity) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.cost = cost;
		this.productImage = productImage;
		this.quantity = quantity;
	}
	
	
	
}


