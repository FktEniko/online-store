package com.eniko.onlinestore.repository;

import com.eniko.onlinestore.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
