package com.cts.idp.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cart_tbl")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private Order order;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false , referencedColumnName = "user_id")
	private User user;
	
	//@OneToOne(mappedBy = "cart")
	@ManyToOne
	@JoinColumn(name = "book_id" , referencedColumnName = "book_id")
	private Catalog catalog;
	
	@JoinColumn(name = "book_name" , referencedColumnName = "book_name")
//	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "quantity")
	private int quantity;
	
	@JoinColumn(name = "net_price" , referencedColumnName = "price")
	@Column(name = "net_price")
	private double bookNetPrice;
	
	@Column(name = "price")
	private double bookPrice;


	public Cart(User user, Catalog catalog, String bookName, int quantity, double bookNetPrice,double bookPrice) {
		super();
		this.user = user;
		this.catalog = catalog;
		this.bookName = bookName;
		this.quantity = quantity;
		this.bookNetPrice = bookNetPrice;
		this.bookPrice = bookPrice;
	}


	
//    @Column(name = "book_id")
//    private int bookId;
//
//    @Column(name = "created_date")
//    private Date createdDate;

//    @ManyToOne
//    @JoinColumn(name = "book_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Catalog catalog;
//	
	

	



	
	

	


}
