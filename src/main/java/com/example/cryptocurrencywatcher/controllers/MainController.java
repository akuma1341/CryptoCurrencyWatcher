package com.example.cryptocurrencywatcher.controllers;

import com.example.cryptocurrencywatcher.entities.User;
import com.example.cryptocurrencywatcher.repositories.UserRepository;
import com.example.cryptocurrencywatcher.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/newUser")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("prices", currencyService.getActualPrices());
        return "newUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}
