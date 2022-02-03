package com.example.cryptocurrencywatcher.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

//    @GetMapping("/newUser")
//    public String newUser(@ModelAttribute("user") User user, Model model) {
//        model.addAttribute("prices", currencyService.getActualPrices());
//        return "newUser";
//    }
//
//    @PostMapping("/createUser")
//    public String createUser(@ModelAttribute("user") User user) {
//        userRepository.save(user);
//        return "redirect:/";
//    }
}
