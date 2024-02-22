package dev.ganeshpc.productservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ganeshpc.productservice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}
