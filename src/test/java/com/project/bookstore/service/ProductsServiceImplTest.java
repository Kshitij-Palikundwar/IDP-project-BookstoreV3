package com.project.bookstore.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.bookstore.dao.ProductsRepository;
import com.project.bookstore.exception.ProductsNotFoundException;
import com.project.bookstore.model.Products;

class ProductsServiceImplTest {

    @Mock
    private ProductsRepository repository;

    @InjectMocks
    private ProductsServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Products product = new Products(1, "Book", "Author", (float) 10.00);
        Mockito.when(repository.save(product)).thenReturn(product);
        Products savedProduct = service.create(product);
        assertEquals(product, savedProduct);
    }

    @Test
    void testFindAll() {
        List<Products> productList = new ArrayList<>();
        productList.add(new Products(1, "Book1", "Author1", (float) 10.00));
        productList.add(new Products(2, "Book2", "Author2", (float) 20.00));
        productList.add(new Products(3, "Book3", "Author3", (float) 30.00));
        Mockito.when(repository.findAll()).thenReturn(productList);
        List<Products> products = service.findAll();
        assertEquals(3, products.size());
    }

    @Test
    void testFindById() {
        int id = 1;
        Products product = new Products(id, "Book", "Author", (float) 10.00);
        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(product));
        Products foundProduct = service.findById(id);
        assertEquals(product, foundProduct);
    }

    @Test
    void testDeleteById() {
        int id = 1;
        Products product = new Products(id, "Book", "Author", (float) 10.00);
        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(product));
        assertDoesNotThrow(() -> service.deleteById(id));
        Mockito.verify(repository, Mockito.times(1)).deleteById(id);
    }

    @Test
    void testFindProductsByProductName() {
        String productName = "Book";
        Products product = new Products(1, productName, "Author", (float) 10.00);
        Mockito.when(repository.findProductsByProductName(productName)).thenReturn(java.util.Optional.of(product));
        Products foundProduct = service.findProductsByProductName(productName);
        assertEquals(product, foundProduct);
    }

    @Test
    void testFindProductsByProductNameNotFound() {
        String productName = "Invalid Book Name";
        Mockito.when(repository.findProductsByProductName(productName)).thenReturn(java.util.Optional.empty());
        assertThrows(ProductsNotFoundException.class, () -> service.findProductsByProductName(productName));
    }
}
