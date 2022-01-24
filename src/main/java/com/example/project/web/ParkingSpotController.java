package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/en/parking-spot")
public class ParkingSpotController {

    @GetMapping
    public String getParkingSpotPage(){
        return "parking-spot";
    }
}
