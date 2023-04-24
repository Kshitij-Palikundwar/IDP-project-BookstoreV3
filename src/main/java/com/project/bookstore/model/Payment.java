package com.project.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="order_amount")
	private float amount;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	public Payment(String orderDate, float amount, String paymentMethod) {
		super();
		this.orderDate = orderDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
	}
	

}
