package com.iappsan.fixi.demo.repositories.implementations;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iappsan.fixi.demo.models.dto.Product;
import com.iappsan.fixi.demo.repositories.interfaces.ProductRepository;

@Repository("productRepositoryFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(
            new Product(999L, "Producto de prueba", "Este es un producto de prueba", 0.0)
        );
    }

    @Override
    public Product getProductById(Long id) {
        return new Product(id, "Producto de prueba", "Este es un producto de prueba", 0.0);
    }

}
