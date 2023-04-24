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
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="quantity")
	private int quantity;
    
	@Column(name="price")
	@JoinColumn(name = "price",  referencedColumnName = "net_price")
	private float price;
	
	@Column(name="product_desc")
	private String productDesc;

//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name = "product_id",  referencedColumnName = "id")
//	private List<Cart> cart;
	

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "cart_id",  referencedColumnName = "id")
    private List<Products> products;


    public Cart(int quantity, float price, String productDesc, List<Products> products) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.productDesc = productDesc;
		//this.products = products;
	}
    

}


