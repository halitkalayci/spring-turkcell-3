package com.turkcell.spring.intro.services.concretes;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.repositories.CategoryRepository;
import com.turkcell.spring.intro.services.abstracts.CategoryService;
import com.turkcell.spring.intro.services.dtos.requests.category.AddCategoryRequest;
import com.turkcell.spring.intro.services.dtos.responses.category.AddCategoryResponse;
import com.turkcell.spring.intro.services.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Tutarlı!
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryRepository categoryRepository;
    @Override
    public AddCategoryResponse add(AddCategoryRequest request) {
        if(request.getName().length() < 3)
            throw new RuntimeException("Kategori ismi en az 3 hane olmalıdır.");
        // Manual Mapping
        // ModelMapper,MapStruct
        Category category = CategoryMapper.INSTANCE.categoryFromRequest(request);

        Category savedCategory = categoryRepository.save(category);

        AddCategoryResponse response = new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());
        return response;
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
