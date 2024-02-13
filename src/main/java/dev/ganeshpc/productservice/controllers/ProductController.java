package dev.ganeshpc.productservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping()
    public String getAllProducts() {
        return "This is get all products route";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "This is getProductById: " + id ;
    }

    @PostMapping()
    public String createProduct() {
        return "This is createProduct";
    }

    @PutMapping("/{id}")
    public String updateProductById() {
        return "This is updateProductById";
    }

}
