package dev.ganeshpc.productservice.clients.productservice.fakestore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.ganeshpc.productservice.dtos.product.FakeStoreProductDto;
import dev.ganeshpc.productservice.dtos.product.GenericProductDto;
import dev.ganeshpc.productservice.exceptions.ProductCreationFailedException;
import dev.ganeshpc.productservice.exceptions.ProductNotFoundException;


@Service
public class FakeStoreProductServiceClient{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<GenericProductDto> getAllProducts() throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate
                .getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos = responseEntity.getBody();

        List<GenericProductDto> products = new ArrayList<>();

        if (fakeStoreProductDtos == null) {
            throw new ProductNotFoundException("No products found");
        }

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(fakeStoreProductDto.toProduct());
        }

        return products;
    }

    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate
                .getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("GenericProductDto with id: " + id + " not found.");
        }

        return fakeStoreProductDto.toProduct();
    }

    public GenericProductDto createProduct(GenericProductDto product) throws ProductCreationFailedException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDtoRequest = FakeStoreProductDto.fromProduct(product);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate
                .postForEntity("https://fakestoreapi.com/products", fakeStoreProductDtoRequest,
                        FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if (fakeStoreProductDto == null) {
            throw new ProductCreationFailedException("Failed to create product: " + product.getTitle());
        }

        GenericProductDto responseProduct = fakeStoreProductDto.toProduct();
        return responseProduct;
    }

    public GenericProductDto updateProductById(Long id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDtoRequest = FakeStoreProductDto.fromProduct(product);
        RequestEntity<FakeStoreProductDto> requestEntity = RequestEntity
                .put("https://fakestoreapi.com/products/{id}", id).body(fakeStoreProductDtoRequest);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(requestEntity,
                FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        GenericProductDto responseProduct = fakeStoreProductDto.toProduct();
        return responseProduct;
    }

    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/{id}", HttpMethod.DELETE, null, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        GenericProductDto product = fakeStoreProductDto.toProduct();
        return product;
    }

}
