package com.turkcell.spring.intro.services.mappers;

import com.turkcell.spring.intro.entities.Category;
import com.turkcell.spring.intro.services.dtos.requests.AddCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper
{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    //@Mapping()
    Category categoryFromRequest(AddCategoryRequest request);
}
// 11.15