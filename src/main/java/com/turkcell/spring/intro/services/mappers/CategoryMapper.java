package com.turkcell.spring.intro.services.mappers;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.services.dtos.requests.category.AddCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper
{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    //@Mapping(source = "categoryName", target = "name")
    Category categoryFromRequest(AddCategoryRequest request);
}
