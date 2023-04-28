package com.project.bookstore.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "cart")
public class Cart implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price") 
	private double price;
	
//	@ManyToOne
//	@JoinColumn(name = "product_id")
//	private Products product;
//	
	
	
//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name = "product_id",  referencedColumnName = "product_id")
//	private Products product;
	
	@OneToOne(mappedBy="cart")
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Products products;

	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id",  referencedColumnName = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_id", referencedColumnName = "payment_id")
	private Payment payment;
	
	
	LocalDateTime time = LocalDateTime.now();

	
  
	public Cart(String productName, int quantity, double price, Products products, User user, Payment payment,
			LocalDateTime time) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.products = products;
		this.user = user;
		this.payment = payment;
		this.time = time;
	}


}


