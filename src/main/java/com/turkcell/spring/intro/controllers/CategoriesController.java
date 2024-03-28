package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.repositories.CategoryRepository;
import com.turkcell.spring.intro.services.abstracts.CategoryService;
import com.turkcell.spring.intro.services.dtos.CategoryForAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Endpoint tanımlamak ✅
// İş kodu implementasyonu ❌
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesController
{
    // Controllerlar repository impl. yapmazlar. ❌❌
    // Service impl. yaparlar.
    private final CategoryService categoryService;
    //private String MY_NAME="abc";

    @GetMapping
    public List<Category> getAll(){
        // categoryRepository.save(); // Ekleme ve güncelleme yapar.
        // categoryRepository.findById(1) // verilen id'ye göre veri arar
        // ........
        return categoryService.getAll();
    }
    // SOLID Prensipleri
    // S => Single Responsibility Principle
    @PostMapping
    public void add(@RequestBody CategoryForAddDto dto)
    {
        // ... validation
        // ... loglama
        // ... vb. iş kodları
        categoryService.add(dto);
    }
    // 5 Temel CRUD Operasyonunu kodlamak => CRUD = CREATE READ UPDATE DELETE
    // Listeleme, idye göre getirme, silme, güncelleme ve ekleme.
}
// 9:15