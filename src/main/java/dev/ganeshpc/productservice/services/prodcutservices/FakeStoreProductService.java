package dev.ganeshpc.productservice.services.prodcutservices;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ganeshpc.productservice.clients.productservice.fakestore.FakeStoreProductServiceClient;
import dev.ganeshpc.productservice.dtos.product.GenericProductDto;
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
    public List<GenericProductDto> getAllProducts() throws ProductNotFoundException {
        List<GenericProductDto> products = fakeStoreProductServiceClient.getAllProducts();

        return products;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        GenericProductDto product = fakeStoreProductServiceClient.getProductById(id);

        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) throws ProductCreationFailedException {
        GenericProductDto createdProduct = fakeStoreProductServiceClient.createProduct(product);

        return createdProduct;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto product) {
        GenericProductDto updatedProduct = fakeStoreProductServiceClient.updateProductById(id, product);
        return updatedProduct;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        GenericProductDto product = fakeStoreProductServiceClient.deleteProductById(id);
        return product;
    }
}
