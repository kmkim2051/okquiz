package com.okintern3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.okintern3.entity.Category;

@Getter
@AllArgsConstructor
public class CategoryResponse {

    private long id;

    private String title;

    public static CategoryResponse of(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }
}
