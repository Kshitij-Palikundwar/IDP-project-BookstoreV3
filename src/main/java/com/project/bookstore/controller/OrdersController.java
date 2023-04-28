package com.project.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookstore.model.Cart;
import com.project.bookstore.model.Orders;
import com.project.bookstore.model.Payment;
import com.project.bookstore.model.Products;
import com.project.bookstore.model.User;
import com.project.bookstore.service.CartService;
import com.project.bookstore.service.OrdersService;
import com.project.bookstore.service.PaymentService;
import com.project.bookstore.service.ProductsService;
import com.project.bookstore.service.UsersService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.SystemException;



@RestController
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private OrdersService service;
	@Autowired
	private CartService cartService;
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
	public List<Orders> findAll(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public Orders findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
//	@PostMapping
//	public Orders create(@RequestBody Orders orders) {
//		return service.create(orders);
//	}
	@PostMapping("/addBook")
	public ResponseEntity<Orders> create(@RequestBody Orders order) throws ClassNotFoundException, SystemException {
	    String productName = order.getCart().getProductName();
	    Cart cart = cartService.findByProductName(productName); // retrieve the product from the database using productName
	    if (cart == null) {
	        throw new EntityNotFoundException("Product not found in Cart with productName :" + productName);
	    }
	    order.setCart(cart); // associate the product with the order
	    
//	    String userName = order.getUser().getName();
//	    User user = userService.findByName(userName); // retrieve the user from the database
//	    if (user == null) {
//	        throw new EntityNotFoundException("User not found with name :" + userName);
//	    }
//	    order.setUser(user); // associate the user with the order
	    
	    String paymentMethod = order.getPayment().getPaymentMethod();
	    Payment payment = paymentService.findByPaymentMethod(paymentMethod); // retrieve the product from the database using productName
	    if (payment == null) {
	        throw new EntityNotFoundException("paymentMethod not found :" + paymentMethod);
	    }
	    order.setPayment(payment); // associate the product with the order
	    
	    
	    Orders savedOrders = service.create(order); // persist the order
	    return ResponseEntity.ok(savedOrders);
	}
	
}
