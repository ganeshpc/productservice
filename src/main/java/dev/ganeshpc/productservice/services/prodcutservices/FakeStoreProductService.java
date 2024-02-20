package dev.ganeshpc.productservice.services.prodcutservices;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ganeshpc.productservice.clients.productservice.fakestore.FakeStoreProductServiceClient;
import dev.ganeshpc.productservice.exceptions.ProductCreationFailedException;
import dev.ganeshpc.productservice.exceptions.ProductNotFoundException;
import dev.ganeshpc.productservice.models.Product;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        List<Product> products = fakeStoreProductServiceClient.getAllProducts();

        return products;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Product product = fakeStoreProductServiceClient.getProductById(id);

        return product;
    }

    @Override
    public Product createProduct(Product product) throws ProductCreationFailedException {
        Product createdProduct = fakeStoreProductServiceClient.createProduct(product);

        return createdProduct;
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        Product updatedProduct = fakeStoreProductServiceClient.updateProductById(id, product);
        return updatedProduct;
    }

    @Override
    public Product deleteProductById(Long id) {
        Product product = fakeStoreProductServiceClient.deleteProductById(id);
        return product;
    }
}
