package com.project.bookstore.model;


import java.io.Serializable;
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
@Table(name = "users")
public class  User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
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

	public User(int UserId, String name, String email, String phoneNo, String address) {
		super();
		this.userId=userId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
//		this.cart = cart;
	}

	

	

	

}


