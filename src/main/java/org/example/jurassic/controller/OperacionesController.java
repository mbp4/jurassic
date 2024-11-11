package org.example.jurassic.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jurassic.servicios.OperacionesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/principal")
public class OperacionesController {

    @Autowired
    private OperacionesServicio servicio;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false, defaultValue = "0") String error){
        model.addAttribute("isla", servicio.listadoIsla());
        model.addAttribute("error", error);
        return "listado";
        //sacar el listado de islas dividido
    }

    @GetMapping("/salir")
    public String salir(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/volver")
    public String volver(){
        return "redirect:/principal/list";
    }

    @GetMapping("/prohibido")
    public String prohibido(){
        return "prohibido";
    }
}
