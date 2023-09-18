package com.okintern3.controller;

import com.okintern3.common.ApiResponse;
import com.okintern3.dto.CategoryResponse;
import com.okintern3.entity.Category;
import com.okintern3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ApiResponse<List<CategoryResponse>> getAllCategories() {

        final List<CategoryResponse> categories = categoryService.getAllCategories();

        return ApiResponse.success(categories);
    }

    @GetMapping("/test")
    public String testApi() {
        return "test-success";
    }


}
