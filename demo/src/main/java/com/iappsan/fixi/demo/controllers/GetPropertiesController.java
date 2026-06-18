package com.iappsan.fixi.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/properties")
public class GetPropertiesController {

    @Value("${config.property1}")
    private String property1;

    @Value("${config.property2}")
    private String property2;

    @Value("${config.colorsList}")
    private String[] colorsList;

    @Value("#{${config.jsonMap}}")
    private Map<String, Object> jsonMap;

    @Value("#{${config.jsonMap}.object}")
    private Map<String, Object> jsonMapObject;

    @Autowired
    private Environment env;

    @GetMapping("/get")
    // Tambien se puede pasar directamente el @Value en los parametros del metodo
    public ResponseEntity<?> getProperties() {
        Map<String, Object> response = new HashMap<>();
        response.put("property1", property1);
        response.put("property2", property2);
        response.put("envProp", env.getProperty("config.property2"));
        response.put("colorsList", colorsList);
        response.put("jsonMap", jsonMap);
        response.put("jsonMapObject", jsonMapObject);
        return ResponseEntity.ok(response);
    }

}
