package com.cts.idp.model;

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
@Table(name = "order_tbl")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	 @ManyToOne
	 @JoinColumn(name = "cart_id", nullable = false)
	 private Cart cart;

	//@OneToMany
	@JoinColumn(name="user_id", nullable=false)

	private int userId;
	
	@Column(name = "book_name")
	private String bookName;	
	
	@Column(name = "price")
	private float bookPrice;

	@Column(name= "order_date")
    private String orderDate;
    
	@Column(name= "total_amount")
    private String totalAmount;


	
	

	public Order(int userId, String bookName, float bookPrice, String orderDate, String totalAmount) {
		super();
		this.userId = userId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	


}
