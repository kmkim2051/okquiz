package com.okintern3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.okintern3.common.ApiResponse;
import com.okintern3.dto.CategoryResponse;
import com.okintern3.service.CategoryService;

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
