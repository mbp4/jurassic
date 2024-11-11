package org.example.jurassic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //controlador principal para que automaticamente te lleve al principal

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "redirect:/principal/list";
        //cambiar por el principal (esta vacio aun)
    }
}
