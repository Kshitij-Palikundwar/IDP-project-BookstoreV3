package com.project.bookstore.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="Total_price")
	private float totalPrice;
	
	@Column(name="address")
	private String address;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Users users;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="order_id")
//	private List<Products> products;

	public Orders(String orderDate, float totalPrice, String shippingAddress, Payment payment,
			Users users) {
		super();
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.address = shippingAddress;
		this.payment = payment;
		this.users = users;
//		this.products = products;
	}
	
	
}


