package dev.ganeshpc.productservice.services.prodcutservices;

import java.util.List;

import dev.ganeshpc.productservice.dtos.product.GenericProductDto;
import dev.ganeshpc.productservice.exceptions.ProductCreationFailedException;
import dev.ganeshpc.productservice.exceptions.ProductNotFoundException;

public interface ProductService {
    List<GenericProductDto> getAllProducts() throws ProductNotFoundException;

    GenericProductDto getProductById(Long id) throws ProductNotFoundException;

    GenericProductDto createProduct(GenericProductDto product) throws ProductCreationFailedException;

    GenericProductDto updateProductById(Long id, GenericProductDto product);

    GenericProductDto deleteProductById(Long id);
}
