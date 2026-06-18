package com.iappsan.fixi.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.iappsan.fixi.demo.models.dto.User;
import com.iappsan.fixi.demo.services.interfaces.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/rest")
public class UserRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Juan", "Perez");
        Map<String, Object> model = new HashMap<>();
        model.put("title", "User Details");

        model.put("user", user);
        return model;
    }

    @GetMapping("/products")
    public ResponseEntity<?> getMethodName() {
        HashMap<String, Object> result = productService.getDemoProducts();
        if (result.get("mensaje") == null) {
            System.out.println(result.get("products"));
            System.out.println(result.get("mensaje"));
            return ResponseEntity.ok(result.get("products"));
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", result.get("mensaje"));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    

}
