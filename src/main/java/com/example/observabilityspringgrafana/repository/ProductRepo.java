package com.example.observabilityspringgrafana.repository;

import com.example.observabilityspringgrafana.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
