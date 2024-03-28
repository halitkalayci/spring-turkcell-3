package com.turkcell.spring.intro.repositories;

import com.turkcell.spring.intro.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// Kategoriler tablosu verisine erişmek. ✅
// Endpoint tanımlama ❌
public interface CategoryRepository extends JpaRepository<Category, Integer> { }
