package org.example.jurassic.controller;

import org.example.jurassic.model.entidades.Dinosaurio;
import org.example.jurassic.servicios.OperacionesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crianza")
public class CrianzaController {

    @Autowired
    private OperacionesServicio operacionesServicio;

    @GetMapping("/list")
    public String listadoDinosaurios(Model model) {

        model.addAttribute("dinosaurios", operacionesServicio.listadoDinosaurios());
        model.addAttribute("islas", operacionesServicio.listadoIslas());
        return "crianza";
    }

    @PostMapping("/asignar")
    public String asignarIsla(Dinosaurio dinosaurio, Model model) {
        operacionesServicio.asignar(dinosaurio);
        return "redirect:/crianza/list";
    }

    @GetMapping("/volver")
    public String volver(){
        return "redirect:/principal/list";
    }
}
