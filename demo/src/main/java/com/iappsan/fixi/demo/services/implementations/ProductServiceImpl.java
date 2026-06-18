package com.iappsan.fixi.demo.services.implementations;

import org.springframework.stereotype.Service;

import com.iappsan.fixi.demo.models.dto.Product;
import com.iappsan.fixi.demo.services.interfaces.ProductService;

import java.util.HashMap;
import java.util.List;

@Service("productDemoService")
public class ProductServiceImpl implements ProductService {

    @Override
    public HashMap<String, Object> getDemoProducts() {
        Product p1 = new Product(1L, "Product 1", "Description 1", 10.0);
        Product p2 = new Product(2L, "Product 2", "Description 2", 20.0);
        Product p3 = new Product(3L, "Product 3", "Description 3", 30.0);
        HashMap<String, Object> result = new HashMap<>();
        result.put("products", List.of(p1, p2, p3));
        // result.put("mensaje", "Hola");
        return result;
    }

}
