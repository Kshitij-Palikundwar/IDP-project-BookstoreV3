package com.project.bookstore.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class  Users{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "first_name")
	private String fName;
	
	@Column(name = "last_name")
	private String lName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "address")
	private String address;
	
//	 @OneToMany(cascade = CascadeType.ALL)
//	 @JoinColumn(name="user_id")
//	  private List<Cart> cart;

	public Users(String name, String email, String phoneNo, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
//		this.cart = cart;
	}

	

	

	

}


