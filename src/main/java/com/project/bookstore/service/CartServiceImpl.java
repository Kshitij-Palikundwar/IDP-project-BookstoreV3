package com.project.bookstore.service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.bookstore.model.Cart;
import com.project.bookstore.model.Products;
import com.project.bookstore.dao.CartRepository;
import com.project.bookstore.dao.ProductsRepository;
import com.project.bookstore.exception.CartNotFoundException;
import com.project.bookstore.exception.ProductsNotFoundException;


@Service
public class CartServiceImpl implements  CartService{
	
	@Autowired
	CartRepository repository;
	
	@Autowired
	ProductsRepository prodRepository;
	
	@Override
	public Cart create(Cart cart) {
		
		
		return repository.save(cart);
	}

	@Override
	public List<Cart> findAll() {

		return repository.findAll();
	}

	@Override
	public Cart findById(int id) {
		Optional<Cart> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new CartNotFoundException("Cart-Id not found with id :" + id);
		}
		
		return optional.get();
	}

	@Override
	public void deleteById(int id) throws CartNotFoundException {
		Cart cart = findById(id);
		repository.deleteById(id);
		
	}

	@Override
	public Cart saveCart(Cart cart) {
		Optional<Products> optionalProduct = prodRepository.findById(cart.getProducts().getProductId());
		Products product = optionalProduct.get();
		cart.setProducts(product);
		cart.setPrice(product.getNetCost()*cart.getQuantity());
		cart.setProductName(product.getProductName());
		cart.setTime(LocalDateTime.now());
		return repository.save(cart);
	}

	@Override
	public Cart findByProductName(String productName) {
		Optional<Cart> optional = repository.findCartByProductName(productName);
		if(optional.isEmpty()) {
			throw new ProductsNotFoundException("Book not found with Name :" + productName);
		}		
		return optional.get();
	}
	
	
//	public void addToCart(int carId, CartItem cartItems){
//
//		Products product = productRepository.findById(carId).orElse(null);
//		    cartItems.setProduct(product);
//
//		        cartItems.setQuantity(product.getQuantity());
//		        
//
//		        cartItemsRepository.save(cartItems);
//
//		}
//		public List<CartItem> myCart(String userName){
//
//		    List<CartItem> cartItems = new ArrayList<>();
//		    cartItemsRepository.findByUsername(userName).forEach(cartItems::add);
//
//		    return cartItems;
//		}
	
	
//	
//	public void addItemToCart(CartItem cartItem) {
//		Cart cart = cartItem.getCart();
//		Products product = cartItem.getProduct();
//		Set<CartItem> cartItems = cart.getCartItems();
//		
//		// Check if the cart already contains the product
//		for (CartItem item : cartItems) {
//			if (item.getProduct().equals(product)) {
//				// If so, update the quantity and exit the loop
//				item.setQuantity(item.getQuantity() + cartItem.getQuantity());
//				repository2.saveCartItem(item);
//				return;
//			}
//		}
//		
//		// If the cart does not contain the product, add a new cart item
//		cartItems.add(cartItem);
//		repository2.saveCartItem(cartItem);
//	}

	
//	@Override
//	public ResponseEntity<String> createCart(Map<String, String> requestMap) {
//		try {
//			boolean res = checkCart(requestMap);
//			System.out.println(res);
//			if(checkCart(requestMap)) {
//				repository.save(getCart(requestMap));
//				return new ResponseEntity<String>("Cart added successfully", HttpStatus.OK);
//			}else {
//				return new ResponseEntity<String>("Cannot add Cart.", HttpStatus.BAD_REQUEST);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<String>("Some error occured:", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//
//	private Cart getCart(Map<String, int> requestMap) {
//		double total=0;
//		Cart cart = new Cart();
//		cart.setQuantity(requestMap.get("quantity"));
//		cart.setQuantity(Integer.parseInt(requestMap.get("quantity")));
//		total = (cart.getPrice()) * (cart.getQuantity());
//		cart.setPrice(total);
//		return cart;
//	}
//
//	private boolean checkCart(Map<String, String> requestMap) {
//		System.out.println(requestMap.keySet());
//		System.out.println(requestMap.containsKey("name"));
//		System.out.println(requestMap.containsKey("contactNumber"));
//		System.out.println(requestMap.containsKey("email"));
//		System.out.println(requestMap.containsKey("paymentMethod"));
//		System.out.println(requestMap.containsKey("productName"));
//		System.out.println(requestMap.containsKey("productPrice"));
//		System.out.println(requestMap.containsKey("quantity"));
//		if(requestMap.containsKey("name")
//				&& requestMap.containsKey("contactNumber")
//				&& requestMap.containsKey("email")
//				&& requestMap.containsKey("paymentMethod")
//				&& requestMap.containsKey("productName")
//				&& requestMap.containsKey("productPrice")
//				&& requestMap.containsKey("quantity")) {
//			return true;
//		}
//		return false;
//	}

	
//	@Override
//	public Cart createCartByProducts(String prodName) {
//		
//		return repository.save.CartByProducts(prodName);
//	}
//	
	
	
}


