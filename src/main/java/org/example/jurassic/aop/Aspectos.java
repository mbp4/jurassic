package org.example.jurassic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.jurassic.model.dao.AuditoriaDao;
import org.example.jurassic.model.entidades.Auditoria;
import org.example.jurassic.seguridad.SecurityServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class Aspectos {

    @Autowired
    private SecurityServicio seguridadServicio;

    @Autowired
    private AuditoriaDao auditoriaDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Around("execution(* org.example.jurassic.controller.OperacionesController.nuevo(..)) || execution(* org.example.jurassic.controller.AuditoriaController.list(..)) || execution(* org.example.jurassic.controller.OperacionesController.terminar(..))")
    public Object checkearPermiso(ProceedingJoinPoint joinPoint) throws Throwable {
        String rolUsuario = seguridadServicio.getRolUsuarioActual();
        if (rolUsuario.equals("ROLE_ADMIN")) {
            return joinPoint.proceed();
        } else {
            return "redirect:/principal/prohibido";
        }
    }

    @After("execution(* org.example.jurassic.controller.AuditoriaController.volver())")
    public void borrarDatos() {
        auditoriaDao.deleteAll(); //borramos todas las auditorias cuando se termine el dia
    }
}
