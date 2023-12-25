package com.eniko.onlinestore.serivce;

import com.eniko.onlinestore.dto.ProductDTO;
import com.eniko.onlinestore.model.Product;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface ProductService {

    List<ProductDTO> listAllProducts();
    ProductDTO getById(int id);
    ProductDTO saveProduct(ProductDTO productDTO, int categoryID);
    ProductDTO updateProduct(int id, ProductDTO productDTO);
    void deleteProduct(int id);

    ProductDTO saveProduct(Product product);

    void saveProduct(Product product, int categoryID);
}
