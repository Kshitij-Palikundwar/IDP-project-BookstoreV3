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

import com.cts.app.exceptions.ClassNotFoundException;
import com.cts.app.exceptions.SystemException;

import com.project.bookstore.model.Cart;
import com.project.bookstore.model.Products;
import com.project.bookstore.model.User;
import com.project.bookstore.service.CartService;
import com.project.bookstore.service.ProductsService;
import com.project.bookstore.service.UsersService;


@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartService service;
	@Autowired
	private ProductsService productService;
	@Autowired
	private UsersService userService;
	
	
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
	
//	@PostMapping
//	public Cart create(@RequestBody Cart cart) {
//		return service.create(cart);
//	}
	
	@DeleteMapping("/{id}")	
	public void deleteById(@PathVariable("id") int id) {
		 service.deleteById(id);
	}
	
	@PostMapping("/carts")
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) throws ClassNotFoundException, SystemException {
	    int productId = cart.getProducts().getProductId();
	    Products product = productService.findById(productId); // retrieve the product from the database
	    cart.setProducts(product); // associate the product with the cart
	    
	    int userId = cart.getUser().getUserId();
	    User user = userService.findById(userId); // retrieve the user from the database
	    cart.setUser(user); // associate the user with the cart
	    
	    Cart savedCart = service.saveCart(cart); // persist the cart
	    return ResponseEntity.ok(savedCart);
	}

	
//	@PostMapping("/addToCart")
//	public String addToCart(@PathVariable int carId, @ModelAttribute CartItem cartItems){
//
//	    //to save to cartItem table.
//	    service.addToCart(carId, cartItems);
//
//	    return "products" ;
//	}
	
//	@PostMapping("/addProduct/")
//	void saveCartItem(CartItem cartItem) {
//		service.addItemToCart(cartItem);
//	}
	
//	@PostMapping("/items")
//	public ResponseEntity<CartItem> saveCartItem(@RequestBody CartItem cartItem) {
//	    CartItem savedCartItem = service.addItemToCart(cartItem);
//	    return ResponseEntity.created(URI.create("/carts/items/" + savedCartItem.getId()))
//	            .body(savedCartItem);
//	}


}

