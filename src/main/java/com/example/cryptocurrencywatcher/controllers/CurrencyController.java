package com.example.cryptocurrencywatcher.controllers;

import com.example.cryptocurrencywatcher.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currencies")
public class CurrencyController {
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public String getCurrencies(Model model) {
        model.addAttribute("currencies", currencyService.getCurrencies());
        return "currencies";
    }

    @GetMapping("/{id}")
    public String getCurrencyById(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("currencyInfo", currencyService.getCurrencyInfo(id));
        return "currency";
    }
}
