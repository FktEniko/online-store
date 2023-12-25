package com.eniko.onlinestore.serivce.impl;

import com.eniko.onlinestore.dto.CategoryDTO;
import com.eniko.onlinestore.model.Category;
import com.eniko.onlinestore.repository.CategoryRepo;
import com.eniko.onlinestore.serivce.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;




    @Override
    public CategoryDTO getById(int id) {
        return modelMapper.map(categoryRepo.findById(id), CategoryDTO.class);
    }


    @Override
    public CategoryDTO getCategoryById(int id) {
        return null;
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        Category newCategory = categoryRepo.save(category);

        return modelMapper.map(newCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(int id, CategoryDTO categoryDTO) {
        Category category = categoryRepo.findById(id).get();

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        Category modifiedCategory = categoryRepo.save(category);

        return modelMapper.map(modifiedCategory, CategoryDTO.class);
    }

    @Override
    public void deleteCategory(int id) {
        Category category = categoryRepo.findById(id).get();

        categoryRepo.delete(category);
    }
}
