package org.example.jurassic.controller;

import org.example.jurassic.model.dao.AuditoriaDao;
import org.example.jurassic.model.entidades.Auditoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaDao auditoriaDao;

    @GetMapping("/listar")
    public String list(Model model) {
        List<Auditoria> auditorias = auditoriaDao.findAll();
        System.out.println(auditorias);  // Verifica que las auditorías no están vacías
        model.addAttribute("auditorias", auditorias);
        return "auditoria";
    }


    @GetMapping("/volver")
    public String volver(){
        return "redirect:/principal/list";
    }

}
