package com.project.bookstore.model;
import java.io.Serializable;
import java.util.List;
import java.util.*;

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
	@Column(name = "product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_author")
	private String productAuthor;
	
	@Column(name="product_desc")
	private String productDesc;
	
	@Column(name="net_price")
	private float netCost;
	
	@Column(name="product_quantity")
	private int quantity;
	
	@Column(name="product_image")
	private String productImage;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name = "cart_id",  referencedColumnName = "id")
//	private List<Cart> cart;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
	private Genre genre;
	

	public Products(String productName, String productDesc, float netCost, String productImage,int quantity) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.netCost = netCost;
		this.productImage = productImage;
		this.quantity = quantity;
	}

	public Products(int productId, String productName, String productAuthor, double netCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productAuthor = productAuthor;
		this.netCost = (float) netCost;
	}

	
	
	
	
}


