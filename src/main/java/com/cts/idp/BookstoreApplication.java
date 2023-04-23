package com.cts.idp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.idp.exceptions.ClassNotFoundException;
import com.cts.idp.model.User;
import com.cts.idp.service.CartService;
import com.cts.idp.service.CatalogService;
import com.cts.idp.service.GenreService;
import com.cts.idp.service.OrderService;
import com.cts.idp.service.UserService;
import com.cts.idp.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		log.info("START");
		ConfigurableApplicationContext ctx = SpringApplication.run(BookstoreApplication.class, args);
		
		UserService userService=ctx.getBean(UserService.class);
		log.debug("userService : {}",userService);
		
		CatalogService catalogService=ctx.getBean(CatalogService.class);
		log.debug("catalogService : {}",catalogService);
		
		GenreService genreService=ctx.getBean(GenreService.class);
		log.debug("genreService : {}",genreService);
		
		CartService cartService=ctx.getBean(CartService.class);
		log.debug("cartService : {}",cartService);
		
		OrderService orderService=ctx.getBean(OrderService.class);
		log.debug("orderService : {}",orderService);
		log.info("END");
		
		
		
//		genreService.showAll().forEach(System.out::println);
//		System.out.println("Hello...\nWelcome to Book Store");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		
//		while (true) {
//			System.out.println("\n********************************************************************\n");
//			
//			System.out.println("               BookStore App");
//			System.out.println("              ```````````````");
//			System.out.println("1. User - Manage user accounts and preferences");
//			System.out.println("2. Books Catalog - Browse and search the book catalog");
//			System.out.println("3. Cart Section - View and modify items in your shopping cart");
//			System.out.println("4. Bill Section - Review and pay for your purchases");
//
//			System.out.println("\nPress 0 to Exit.");
//			System.out.println("\n********************************************************************\n");
//			
//			System.out.println("Please select an option from the menu above:");
//			int selection = Integer.parseInt(br.readLine());
//			switch (selection) {
//		    case 1:
//		        // For User Part
//		    	System.out.println("\nPress 1 to Create new User.");
//		    	System.out.println("\nPress 2 to Login.");
//				System.out.println("\nPress 3 to Show all existing Users.");
//				System.out.println("\nPress 4 to Search User using ID.");
//				
//		        break;
//		    case 2:
//		        // For Books Catalog
//		    	System.out.println("\nPress 5 to Show all Books.");
//				System.out.println("\nPress 6 to Search Book By Name.");
//				System.out.println("\nPress 7 to Search Book By Category/Genre.");
//				System.out.println("\nPress 8 to Add book to Cart Section from Books catalog.");
//		        break;
//		    case 3:
//		        // For Cart Section 
//		    	System.out.println("\nPress 9 to Show Books present in Cart.");
//		        break;
//		    case 4:
//		        // For Bill Section 
//		    	System.out.println("\nPress 10 to Show Books present in Bill.");
//		    	System.out.println("\nPress 11 to Add Books present in Cart to the Bill.");
//		        break;
//		        
//		    default:
//		        System.out.println("\nInvalid choice. Please choose from above options.");
//		}
//			
//			// Yet to Implement this part
//			
//			
////			System.out.println("Press 9 Add book to Bill Section.");
////			System.out.println("Press 10 Generate Bill / Show All items in Bill Section.");
//
//			// To get the input Number from user to perform required operation
//			int input = Integer.parseInt(br.readLine());
//			if (input == 0) {
//				System.out.println("Thanks for using app have a great day...");
//				System.out.println("\n**************************************************************************\n");
//				break;
//			}
//
//			// ADD User
//			if (input == 1) {
//				System.out.println("Enter User First Name: ");
//				String fName = br.readLine();
//				
//				System.out.println("Enter User Last Name: ");
//				String lName = br.readLine();
//				
//				System.out.println("Enter your Mail Id: ");
//				String mail = br.readLine();
//
//				System.out.println("Enter your Phone No: ");
//				String phno = br.readLine();
//
//				System.out.println("Enter your Address: ");
//				String addr = br.readLine();
//				
//				System.out.println("Enter Password: ");
//				String psw = br.readLine();
//
//				log.debug("service : {}",service);
//				service.create(new User(fName, lName, mail, phno, addr, psw));
//				log.info("END");		
//			} 
//			// Show All Users
//			else if (input == 3) {
//				System.out.println("~~~~~~~~~~~~~~~~~~~~ User List ~~~~~~~~~~~~~~~~~~~~");
//				log.debug("service : {}",service);
//				service.findAll().forEach(System.out::println);
//				log.info("END");
//			}
//
//			// Searching User by ID
//			else if (input == 4) {
//				System.out.println("Enter User Id to be searched : ");
//				int UserId = Integer.parseInt(br.readLine());
//				try {
//					log.debug("service : {}",service);
//					System.out.println(service.findById(UserId));
//					log.info("END");
//
//				} catch (UserNotFoundException e) {
//					System.err.println(e.getMessage());
//				}
//			}
//			
//			
////		log.debug("service : {}",service);
////		service.create(new User("Kshitij","P","kshitij@gmail.com","789564132","Nagpur","Kshitij@1234"));
////		log.info("END");
////		
//		
//		
//		
//		}
	}
}
