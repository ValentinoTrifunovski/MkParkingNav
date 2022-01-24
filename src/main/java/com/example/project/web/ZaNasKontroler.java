package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mk/za-nas")
public class ZaNasKontroler {

    @GetMapping
    public String getZaNasPage() {
        return "za-nas";
    }
}
