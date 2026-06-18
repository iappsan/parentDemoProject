package com.iappsan.fixi.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.iappsan.fixi.demo.models.dto.User;

import org.springframework.ui.Model;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Juan", "Perez");
        model.addAttribute("title", "User Details");
        // user.setLastName("Gomez");
        user.setPhone("9876543210");
        model.addAttribute("user", user);

        return "details";
    }

    @ModelAttribute("usersList2")
    public List<User> usersList2() {
        User uList1 = new User("Maria", "Lopez");
        User uList2 = new User("Carlotas", "Garcia");
        uList2.setPhone("5555555555");
        User uList3 = new User("Ana", "Martinez");
        return Arrays.asList(uList1, uList2, uList3);
    }
}
