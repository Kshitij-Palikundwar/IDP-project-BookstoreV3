package com.project.bookstore;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.bookstore.service.CartService;
import com.project.bookstore.service.GenresService;
import com.project.bookstore.service.OrdersService;
import com.project.bookstore.service.PaymentService;
import com.project.bookstore.service.ProductsService;
import com.project.bookstore.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		log.info("START");
		ConfigurableApplicationContext ctx = SpringApplication.run(BookstoreApplication.class, args);
		
		UsersService userService=ctx.getBean(UsersService.class);
		log.debug("userService : {}",userService);
		
		ProductsService catalogService=ctx.getBean(ProductsService.class);
		log.debug("catalogService : {}",catalogService);
		
		GenresService genreService=ctx.getBean(GenresService.class);
		log.debug("genreService : {}",genreService);
		
		CartService cartService=ctx.getBean(CartService.class);
		log.debug("cartService : {}",cartService);
		
		PaymentService paymentService=ctx.getBean(PaymentService.class);
		log.debug("paymentService : {}",paymentService);
		
		OrdersService orderService=ctx.getBean(OrdersService.class);
		log.debug("orderService : {}",orderService);
		log.info("END");
		
		
	}
}
