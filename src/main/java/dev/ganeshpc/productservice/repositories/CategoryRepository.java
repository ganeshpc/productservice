package dev.ganeshpc.productservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ganeshpc.productservice.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    
}
