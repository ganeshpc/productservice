package dev.ganeshpc.productservice.controllers;

import org.springframework.web.bind.annotation.RestController;

import dev.ganeshpc.productservice.dtos.product.GenericProductDto;
import dev.ganeshpc.productservice.dtos.product.RequestProductDto;
import dev.ganeshpc.productservice.dtos.product.ResponseProductDto;
import dev.ganeshpc.productservice.exceptions.ProductCreationFailedException;
import dev.ganeshpc.productservice.exceptions.ProductNotFoundException;
import dev.ganeshpc.productservice.models.Product;
import dev.ganeshpc.productservice.services.prodcutservices.ProductService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ResponseProductDto> getAllProducts() throws ProductNotFoundException {
        List<ResponseProductDto> responseProductDtos = new ArrayList<>();
        List<GenericProductDto> products = productService.getAllProducts();
        for (GenericProductDto product : products) {
            responseProductDtos.add(ResponseProductDto.fromGenericProductDto(product));
        }
        return responseProductDtos;
    }

    @GetMapping("/{id}")
    public ResponseProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        GenericProductDto product = productService.getProductById(id);
        ResponseProductDto responseProductDto = ResponseProductDto.fromGenericProductDto(product);
        return responseProductDto;
    }

    @PostMapping()
    public ResponseProductDto createProduct(@RequestBody RequestProductDto requestProductDto) throws ProductCreationFailedException {
        GenericProductDto product = productService.createProduct(requestProductDto.toGenericProductDto());
        ResponseProductDto responseProductDto = ResponseProductDto.fromGenericProductDto(product);
        return responseProductDto;
    }

    @PutMapping("/{id}")
    public ResponseProductDto updateProductById(@PathVariable("id") Long id,
            @RequestBody RequestProductDto requestProductDto) {
        GenericProductDto requestProduct = requestProductDto.toGenericProductDto();
        GenericProductDto product = productService.updateProductById(id, requestProduct);
        ResponseProductDto responseProductDto = ResponseProductDto.fromGenericProductDto(product);
        return responseProductDto;
    }

    @DeleteMapping("/{id}")
    public ResponseProductDto deleteProductById(@PathVariable("id") Long id) {
        GenericProductDto product = productService.deleteProductById(id);
        ResponseProductDto responseProductDto = ResponseProductDto.fromGenericProductDto(product);
        return responseProductDto;
    }
}
