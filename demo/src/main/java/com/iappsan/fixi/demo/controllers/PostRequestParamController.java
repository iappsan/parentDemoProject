package com.iappsan.fixi.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iappsan.fixi.demo.models.dto.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/api")
public class PostRequestParamController {

    @PostMapping("/requestBody")
    public ResponseEntity<?> postMethodName(@RequestBody User user) {
        Map <String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("message", "User received successfully");
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/requestBodyMap")
    public ResponseEntity<?> postMethodParams(@RequestBody Map<String, Object> params) {
        Map <String, Object> response = new HashMap<>();
        if (params.isEmpty()) {
            response.put("message", "No params provided");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("objeto", params.get("objeto"));
        response.put("message", "Params received successfully");
        return ResponseEntity.ok(response);
    }
    
    
}
