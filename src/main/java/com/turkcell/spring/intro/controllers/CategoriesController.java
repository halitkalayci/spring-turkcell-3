package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesController
{
    private final CategoryRepository categoryRepository;
    //private String MY_NAME="abc";

    @GetMapping
    public List<Category> getAll(){
        // categoryRepository.save(); // Ekleme ve güncelleme yapar.
        // categoryRepository.findById(1) // verilen id'ye göre veri arar
        // ........
        return categoryRepository.findAll();
    }
    // 5 Temel CRUD Operasyonunu kodlamak => CRUD = CREATE READ UPDATE DELETE
    // Listeleme, idye göre getirme, silme, güncelleme ve ekleme.
}
