package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);
        assertEquals(product, createdProduct);
        verify(productRepository).create(product);
    }

    @Test
    void testDeleteProductById() {
        String productId = "123";
        Product product = new Product();
        when(productRepository.deleteById(productId)).thenReturn(product);

        Product deletedProduct = productService.deleteById(productId);
        assertEquals(product, deletedProduct);
        verify(productRepository).deleteById(productId);
    }

    @Test
    void testFindProductById() {
        String productId = "123";
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(product);

        Product foundProduct = productService.findById(productId);
        assertEquals(product, foundProduct);
        verify(productRepository).findById(productId);
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        when(productRepository.editProduct(product)).thenReturn(product);

        Product editedProduct = productService.edit(product);
        assertEquals(product, editedProduct);
        verify(productRepository).editProduct(product);
    }

    @Test
    public void testFindAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());

        Iterator<Product> iterator = productList.iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        assertEquals(productList.size(), result.size());
        verify(productRepository, times(1)).findAll();
    }
}
