package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "HomePage";
    }
}