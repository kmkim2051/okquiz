package com.okintern3.dto;

import com.okintern3.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryResponse {

    private String category;

    public static CategoryResponse of(Category category) {
        return new CategoryResponse(category.getName());
    }
}
