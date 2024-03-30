package com.turkcell.spring.intro.repositories;

import com.turkcell.spring.intro.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
