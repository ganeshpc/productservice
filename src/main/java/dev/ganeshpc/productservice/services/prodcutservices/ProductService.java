package dev.ganeshpc.productservice.services.prodcutservices;

import java.util.List;

import dev.ganeshpc.productservice.models.Product;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProductById(Long id, Product product);

    Product deleteProductById(Long id);
}
