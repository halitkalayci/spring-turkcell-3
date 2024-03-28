package com.turkcell.spring.intro.services.abstracts;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.services.dtos.CategoryForAddDto;

import java.util.List;

// Servisler hiç bir noktada direkt Entity classları ile çalışmaz! ❌❌❌
public interface CategoryService
{
    void add(CategoryForAddDto dto);
    void update(Category category);
    void delete(int id);
    List<Category> getAll();
    Category getById(int id);
}
// Data Transfer Object
