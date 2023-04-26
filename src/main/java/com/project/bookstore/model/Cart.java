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
	
	
	LocalDateTime time = LocalDateTime.now();

	
    public Cart(int quantity, float price) {
		super();
		this.quantity = quantity;
		this.price = price;
//		this.productDesc = productDesc;
		//this.products = products;
	}
    

}


