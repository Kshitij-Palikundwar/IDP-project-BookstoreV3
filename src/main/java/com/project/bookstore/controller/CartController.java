package com.project.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.bookstore.model.Cart;
import com.project.bookstore.model.Payment;
import com.project.bookstore.model.Products;
import com.project.bookstore.model.User;
import com.project.bookstore.service.UsersService;
import com.project.bookstore.service.CartService;
import com.project.bookstore.service.PaymentService;
import com.project.bookstore.service.ProductsService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.SystemException;


@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartService service;
	@Autowired
	private UsersService userService;
	@Autowired
	private ProductsService productService;
	@Autowired
	private PaymentService paymentService;
	
	
	/*
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping
	public List<Cart> findAll(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public Cart findById(@PathVariable("id") int id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")	
	public void deleteById(@PathVariable("id") int id) {
		 service.deleteById(id);
	}
	
	


	
	@PostMapping("/addBook")
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) throws ClassNotFoundException, SystemException {
	    String productName = cart.getProducts().getProductName();
	    Products product = productService.findProductsByProductName(productName); // retrieve the product from the database using productName
	    if (product == null) {
	        throw new EntityNotFoundException("Product not found with productName :" + productName);
	    }
	    cart.setProducts(product); // associate the product with the cart
	    
	    String userName = cart.getUser().getName();
	    User user = userService.findByName(userName); // retrieve the user from the database
	    if (user == null) {
	        throw new EntityNotFoundException("User not found with name :" + userName);
	    }
	    cart.setUser(user); // associate the user with the cart
	    
//	    String paymentMethod = cart.getPayment().getPaymentMethod();
//	    Payment payment = paymentService.findByPaymentMethod(paymentMethod); // retrieve the product from the database using productName
//	    if (payment == null) {
//	        throw new EntityNotFoundException("paymentMethod not found :" + paymentMethod);
//	    }
//	    cart.setPayment(payment); // associate the product with the cart
	    
	    
	    Cart savedCart = service.saveCart(cart); // persist the cart
	    return ResponseEntity.ok(savedCart);
	}

	



}

