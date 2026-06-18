package com.iappsan.fixi.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class HomeController {

    @GetMapping({"","/home","/index","/"})
    public String goHome(Model model) {
        return "homePage";
    }
    

    //Redirect reinicia el ciclo de vida de la petición, se pierde el modelo y se hace una nueva petición al controlador destino
    @GetMapping({"/homeR"})
    public String home() {
        return "redirect:/details";
    }

    //Forward mantiene el modelo y no reinicia el ciclo de vida de la petición, se pasa directamente al controlador destino sin hacer una nueva petición
    @GetMapping({"/homeF"})
    public String home2() {
        return "forward:/details";
    }
    
}
