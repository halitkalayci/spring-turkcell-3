package com.turkcell.spring.intro.repositories;

import com.turkcell.spring.intro.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// Kategoriler tablosu verisine erişmek. ✅
// Endpoint tanımlama ❌
public interface CategoryRepository extends JpaRepository<Category, Integer>
{
    // Derived Query Methods
    Optional<Category> findByNameIgnoreCase(String name);
}
