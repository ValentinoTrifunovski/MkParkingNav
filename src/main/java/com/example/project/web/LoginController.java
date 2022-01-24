package com.example.project.web;

import com.example.project.model.User;
import com.example.project.model.exceptions.InvalidUserCredentialsException;
import com.example.project.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {

        User user = null;
        try {
            user = this.authService.login(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/en/home";
        } catch (InvalidUserCredentialsException e){
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "/login";
        }

    }

}
