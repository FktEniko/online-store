package com.eniko.onlinestore.serivce;

import com.eniko.onlinestore.dto.CategoryDTO;

import java.util.List;

import java.util.List;

public interface CategoryService {

    static List<CategoryDTO> listAllCategory() {
        return null;
    }

    CategoryDTO getById(int id);

    CategoryDTO getCategoryById(int id);
    CategoryDTO saveCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(int id, CategoryDTO categoryDTO);
    void deleteCategory(int id);
}
