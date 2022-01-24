package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mk/parking-mesto")
public class ParkingMestoKontroler {

    @GetMapping
    public String getParkingMestoPage(){
        return "parking-mesto";
    }

}
