package com.example.CustomTech_Backend.controller.homeController;

import com.example.CustomTech_Backend.entity.homeEntity.HomeAbout;
import com.example.CustomTech_Backend.service.homeService.HomeAboutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/home/about")
public class HomeAboutController {

    private final HomeAboutService service;

    public HomeAboutController(HomeAboutService service) {
        this.service = service;
    }

    @GetMapping
    public HomeAbout getAbout() {
        return service.getAbout();
    }

    @PutMapping
    public HomeAbout updateAbout(@RequestBody HomeAbout about) {
        return service.updateAbout(about);
    }
}
