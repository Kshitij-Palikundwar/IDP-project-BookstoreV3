package com.project.bookstore.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Orders implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_id", referencedColumnName = "payment_id")
	private Payment payment;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "cart_id",  referencedColumnName = "cart_id")
	private Cart cart;
		
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="order_id")
//	private List<Products> products;

//	public Orders( Payment payment,User user,Cart cart) {
//		super();
//		this.payment = payment;
//		this.user = user;
//		this.cart = cart;
//	}
	
	
}


