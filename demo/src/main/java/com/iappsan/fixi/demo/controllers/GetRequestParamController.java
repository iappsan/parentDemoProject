package com.iappsan.fixi.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iappsan.fixi.demo.models.dto.ParamDTO;
import com.iappsan.fixi.demo.models.dto.User;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
public class GetRequestParamController {

    @GetMapping("/requestParam")
    // Se puede usar tambien @DefaultValue("Default message") en lugar de required = false y el operador ternario para asignar un valor por defecto
    public ParamDTO foo(@RequestParam(required = false) String message) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message != null ? message : "No message provided");
        return paramDTO;
    }

    @GetMapping("/httpServletRequest")
    public String getMethodName(
        HttpServletRequest request, 
        @RequestParam String param) {
            String message = request.getParameter("message");
        return message != null ? message : "No message provided";
    }
    
    @GetMapping("/pathVariable/{id}")
    public String getPathVariable(@PathVariable String id) {
        return id;
    }

    @GetMapping("/multiplePathVariable/{id}/{name}")
    public ResponseEntity<?> getMultiplePathVariables(
        @PathVariable String id, 
        @PathVariable String name) {
            User user = new User(name, "Doe");
            user.setId(id);
        return ResponseEntity.ok(user);
    }
}
