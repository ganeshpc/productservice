package dev.ganeshpc.productservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ganeshpc.productservice.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    
}
