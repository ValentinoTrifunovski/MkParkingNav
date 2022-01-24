package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mk/pocetna")
public class PocetnaKontroler {

    @GetMapping
    public String getHomePage() {
        return "pocetna";
    }

}

