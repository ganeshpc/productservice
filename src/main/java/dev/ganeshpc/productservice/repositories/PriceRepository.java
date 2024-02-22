package dev.ganeshpc.productservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ganeshpc.productservice.models.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {

    
} 