package com.iappsan.fixi.demo.repositories.interfaces;

import java.util.List;

import com.iappsan.fixi.demo.models.dto.Product;

public interface ProductRepository {
    
    public List<Product> findAll();
    public Product getProductById(Long id);

}
