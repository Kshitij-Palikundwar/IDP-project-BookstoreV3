package com.project.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.bookstore.model.User;
import com.project.bookstore.dao.UsersRepository;
import com.project.bookstore.exception.UsersNotFoundException;

public class UsersServiceImplTest {

	@InjectMocks
	private UsersServiceImpl usersService;

	@Mock
	private UsersRepository repository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate() {
		User user = new User();
		user.setUserId(1);
		user.setName("Kshitij");
		user.setEmail("Kshitij@example.com");

		Mockito.when(repository.save(Mockito.any(User.class))).thenReturn(user);

		User result = usersService.create(user);

		assertEquals(user, result);
	}

	@Test
	public void testFindAll() {
		User user1 = new User();
		user1.setUserId(1);
		user1.setName("Kshitij");
		user1.setEmail("Kshitij@example.com");

		User user2 = new User();
		user2.setUserId(2);
		user2.setName("Satyam");
		user2.setEmail("Satyam@example.com");

		List<User> userList = Arrays.asList(user1, user2);

		Mockito.when(repository.findAll()).thenReturn(userList);

		List<User> result = usersService.findAll();

		assertEquals(userList, result);
	}

	@Test
	public void testFindById() {
		User user = new User();
		user.setUserId(1);
		user.setName("Kshitij");
		user.setEmail("Kshitij@example.com");

		Optional<User> optional = Optional.of(user);

		Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optional);

		User result = usersService.findById(1);

		assertEquals(user, result);
	}

	@Test
	public void testFindByIdThrowsException() {
		Optional<User> optional = Optional.empty();

		Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optional);

		assertThrows(UsersNotFoundException.class, () -> {
			usersService.findById(1);
		});
	}

	@Test
	public void testDeleteById() {
		User user = new User();
		user.setUserId(1);
		user.setName("Kshitij");
		user.setEmail("Kshitij@example.com");

		Optional<User> optional = Optional.of(user);

		Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optional);

		usersService.deleteById(1);

		Mockito.verify(repository, Mockito.times(1)).deleteById(Mockito.anyInt());
	}

	@Test
	public void testDeleteByIdThrowsException() {
		Optional<User> optional = Optional.empty();

		Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optional);

		assertThrows(UsersNotFoundException.class, () -> {
			usersService.deleteById(1);
		});
	}

}
