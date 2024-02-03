package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product findById(String productId){
        return productData.stream().filter(
                product -> productId.equals(product.getProductId())
        ).findFirst().orElseThrow(() ->
                new IllegalArgumentException("Invalid product Id")
        );
    }

    public Product deleteById(String productId) {
        Product product = findById(productId);
        productData.remove(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}
