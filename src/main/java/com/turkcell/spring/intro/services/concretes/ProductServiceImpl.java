package com.turkcell.spring.intro.services.concretes;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.entities.Product;
import com.turkcell.spring.intro.repositories.ProductRepository;
import com.turkcell.spring.intro.services.abstracts.ProductService;
import com.turkcell.spring.intro.services.dtos.requests.product.AddProductRequest;
import com.turkcell.spring.intro.services.mappers.CategoryMapper;
import com.turkcell.spring.intro.services.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void add(AddProductRequest request) {
        Product product = ProductMapper.INSTANCE.productFromAddRequest(request);

        /*Product manualProduct = new Product();
        manualProduct.setUnitPrice(request.getUnitPrice());
        manualProduct.setName(request.getName());

        Category category = new Category();
        category.setId(request.getCategoryId());
        manualProduct.setCategory(category);*/

        productRepository.save(product);
    }
}
