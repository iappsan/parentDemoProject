package com.iappsan.fixi.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iappsan.fixi.demo.models.dto.Product;
import com.iappsan.fixi.demo.services.interfaces.ProductRepoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/products")
public class ProductRepoController {

    @Autowired
    private ProductRepoService productRepoService;

    @GetMapping
    public List<Product> getMethodName() {
        return productRepoService.findAll();
    }
    
    @GetMapping("/{id}")
    public Product getMethodName(@PathVariable String id) {
        return productRepoService.getProductById(Long.parseLong(id));
    }
    
}
