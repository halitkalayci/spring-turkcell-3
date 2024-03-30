package com.turkcell.spring.intro.services.mappers;

import com.turkcell.spring.intro.entities.Product;
import com.turkcell.spring.intro.services.dtos.requests.product.AddProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categoryId", target = "category.id")
    Product productFromAddRequest(AddProductRequest request);
}
