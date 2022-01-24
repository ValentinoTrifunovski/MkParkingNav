package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/en/home", "/"})
public class HomeController {

    @GetMapping
    public String getHomePage() {
        return "home";
    }

}
