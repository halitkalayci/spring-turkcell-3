package com.turkcell.spring.intro.services.concretes;

import com.turkcell.spring.intro.core.utils.exceptions.types.BusinessException;
import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.repositories.CategoryRepository;
import com.turkcell.spring.intro.services.abstracts.CategoryService;
import com.turkcell.spring.intro.services.dtos.requests.category.AddCategoryRequest;
import com.turkcell.spring.intro.services.dtos.responses.category.AddCategoryResponse;
import com.turkcell.spring.intro.services.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Tutarlı!
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryRepository categoryRepository;
    @Override
    public AddCategoryResponse add(AddCategoryRequest request) {
        List<String> a = new ArrayList<>();
        a.add("merhaba");

        a.get(3);

        categoryWithSameNameShouldNotExist(request.getName());

        Category category = CategoryMapper.INSTANCE.categoryFromRequest(request);

        Category savedCategory = categoryRepository.save(category);

        return new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());
    }
    // 21:10
    @Override
    public void update(Category category) {
        categoryWithSameNameShouldNotExist(category.getName());
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

    // Global Ex. Handling.
    private void categoryWithSameNameShouldNotExist(String name){
        Optional<Category> categoryWithSameName = categoryRepository.findByNameIgnoreCase(name);
        if(categoryWithSameName.isPresent()){
            throw new BusinessException("Aynı isimle 2. kategori eklenemez.");
            // İş kuralı ihlalinde RuntimeException =>
        }
    }
}
