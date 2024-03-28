package com.turkcell.spring.intro.services.concretes;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.repositories.CategoryRepository;
import com.turkcell.spring.intro.services.abstracts.CategoryService;
import com.turkcell.spring.intro.services.dtos.CategoryForAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Tutarlı!
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryRepository categoryRepository;
    @Override
    public void add(CategoryForAddDto dto) {
        if(dto.getName().length() < 3)
            throw new RuntimeException("Kategori ismi en az 3 hane olmalıdır.");
        // Manual Mapping
        // ModelMapper,MapStruct
        Category category = new Category();
        category.setName(dto.getName());
        categoryRepository.save(category);
    }
    // 21:10
    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category==null)
            throw new RuntimeException("Silinmek istenen kategori bulunamadı.");

        categoryRepository.delete(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}
