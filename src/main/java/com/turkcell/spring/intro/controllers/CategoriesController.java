package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.services.abstracts.CategoryService;
import com.turkcell.spring.intro.services.dtos.requests.AddCategoryRequest;
import com.turkcell.spring.intro.services.dtos.responses.AddCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<AddCategoryResponse> add(@RequestBody AddCategoryRequest request)
    {
        AddCategoryResponse response = categoryService.add(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("{id}")
    public Category getDetails(@PathVariable int id)
    {
        return categoryService.getById(id);
    }
    @PutMapping
    public void update(@RequestBody Category category)
    {
        categoryService.update(category);
    }
    // 5 Temel CRUD Operasyonunu kodlamak => CRUD = CREATE READ UPDATE DELETE
    // Listeleme, idye göre getirme, silme, güncelleme ve ekleme.
}
// 9:15