package com.abhishek.ecommerce_api.service;

import com.abhishek.ecommerce_api.dto.request.CategoryRequest;
import com.abhishek.ecommerce_api.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);

    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategoryById(Long id);

    CategoryResponse updateCategory(Long id, CategoryRequest request);

    void deleteCategory(Long id);
}