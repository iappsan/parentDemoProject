package com.iappsan.fixi.demo.services.interfaces;

import java.util.List;

import com.iappsan.fixi.demo.models.dto.Product;

public interface ProductRepoService {

    public List<Product> findAll();
    public Product getProductById(Long id);
}
