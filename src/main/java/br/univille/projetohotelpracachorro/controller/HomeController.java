package br.univille.projetohotelpracachorro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class HomeController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("home/index");
    }
}
