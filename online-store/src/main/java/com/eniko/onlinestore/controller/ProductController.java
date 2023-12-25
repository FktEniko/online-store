package com.eniko.onlinestore.controller;

import com.eniko.onlinestore.dto.CategoryDTO;
import com.eniko.onlinestore.dto.ProductDTO;
import com.eniko.onlinestore.model.Product;
import com.eniko.onlinestore.serivce.*;
import com.eniko.onlinestore.serivce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@RestController
@Controller
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/getAll")
    public String getAll(Model model, RedirectAttributes redirectAttributes) {
        List<ProductDTO> products = productService.listAllProducts();
        List<CategoryDTO> categories = CategoryService.listAllCategory(); // Példányosítás
        model.addAttribute("products", products);
        model.addAttribute("categories", categories); // Átadás a modelnek
        model.addAttribute("product", new ProductDTO()); // Ha szeretnéd megőrizni az űrlap adatait a redirect után
        model.addAttribute("successMessage", redirectAttributes.getFlashAttributes().get("successMessage")); // Átadás a modelnek a flash attribútumokból
        return "product"; // Ez a sablon neve
    }


    @PostMapping("/add") // nem kell paraméter a végpontban
    public String addProduct(@ModelAttribute("product") ProductDTO productDTO) {
        productService.saveProduct(productDTO, productDTO.getCategoryId());
        RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
        redirectAttributes.addFlashAttribute("successMessage", "Product added successfully");
        return "redirect:/api/products/getAll";
    }



    @GetMapping("/getById")
    public ProductDTO getById(@RequestParam int id){
        return productService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ProductDTO update(@RequestBody ProductDTO product, @PathVariable int id){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
