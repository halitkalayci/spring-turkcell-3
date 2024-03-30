package com.turkcell.spring.intro.services.dtos.responses.category;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryResponse
{
    private int id;
    private String name;
}
