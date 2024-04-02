package com.turkcell.spring.intro.services.dtos.requests.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest
{
    // TODO: Multi-language
    @NotBlank(message = "Kategori ismi boş geçilemez.")
    @Size(min = 2, max = 50, message = "Kategori ismi en az 2, en fazla 50 karakter olmalıdır.")
    private String name;
}
