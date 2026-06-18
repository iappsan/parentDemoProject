package com.iappsan.fixi.demo.repositories.implementations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.iappsan.fixi.demo.models.dto.Product;
import com.iappsan.fixi.demo.repositories.interfaces.ProductRepository;

import tools.jackson.databind.ObjectMapper;

@Repository("productRepositoryJson")
public class ProductRepositoryJson implements ProductRepository {

    private List<Product> productsData;

    public ProductRepositoryJson() {
        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            productsData = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return productsData;
    }

    @Override
    public Product getProductById(Long id) {
        return productsData.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

}
