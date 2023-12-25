package com.eniko.onlinestore.controller;

import com.eniko.onlinestore.dto.CategoryDTO;
import com.eniko.onlinestore.serivce.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("/getAll")
    public String getAll(Model model){
        List<CategoryDTO> categories = CategoryService.listAllCategory();
        model.addAttribute("categories", categories);
        return "category"; // Ez a sablon neve
    }
    @GetMapping("/getById")
    public CategoryDTO getById(@RequestParam int id){
        return categoryService.getById(id);
    }

    @GetMapping("/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new CategoryDTO());
        return "addCategory";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") CategoryDTO categoryDTO) {
        categoryService.saveCategory(categoryDTO);
        return "redirect:/categories/add";
    }
    @PutMapping("/update/{id}")
    public CategoryDTO update(@RequestBody CategoryDTO categoryDTO, @PathVariable int id){
        return categoryService.updateCategory(id, categoryDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
