package com.cts.idp.model;

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
@Table(name = "user_tbl")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "phone_no")
	private String ph;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;


	public User(String firstName, String lastName, String mail, String ph, String address, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.ph = ph;
		this.address = address;
		this.password = password;
	}

	


}
