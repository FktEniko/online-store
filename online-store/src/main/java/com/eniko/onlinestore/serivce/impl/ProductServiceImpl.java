package com.eniko.onlinestore.serivce.impl;

import com.eniko.onlinestore.dto.ProductDTO;
import com.eniko.onlinestore.model.Category;
import com.eniko.onlinestore.model.Product;
import com.eniko.onlinestore.repository.CategoryRepo;
import com.eniko.onlinestore.repository.ProductRepo;
import com.eniko.onlinestore.serivce.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public  class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDTO> listAllProducts() {
        List<Product> products = productRepo.findAll();
        return Arrays.asList(modelMapper.map(products, ProductDTO[].class));
    }

    @Override
    public ProductDTO getById(int id) {
        Optional<Product> productOptional = productRepo.findById(id);
        return productOptional.map(product -> modelMapper.map(product, ProductDTO.class)).orElse(null);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO, int categoryID) {
        // Implementáld a termék mentési logikát itt

        // Példa: a termék létrehozása és mentése
        Product product = modelMapper.map(productDTO, Product.class);

        // Kategória betöltése az azonosító alapján
        Optional<Category> categoryOptional = categoryRepo.findById(categoryID);
        categoryOptional.ifPresent(product::setCategory);

        Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        // Implementáld a termék frissítési logikát itt

        // Példa: a termék betöltése az azonosító alapján
        Optional<Product> productOptional = productRepo.findById(id);
        return productDTO;
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public ProductDTO saveProduct(Product product) {
        return null;
    }

    @Override
    public void saveProduct(Product product, int categoryID) {

    }
}

