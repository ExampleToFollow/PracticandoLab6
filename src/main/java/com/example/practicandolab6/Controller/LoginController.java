package com.example.practicandolab6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        System.out.println("ESTOY EN EL LOGIN!");
        return "/loginForm";
    }
}
