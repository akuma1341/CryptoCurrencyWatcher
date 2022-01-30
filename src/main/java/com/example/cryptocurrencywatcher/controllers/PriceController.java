package com.example.cryptocurrencywatcher.controllers;

import com.example.cryptocurrencywatcher.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping
    public String getPrices(@RequestParam(name = "user", required = false) String userName, Model model) {
        if (userName != null) {
            model.addAttribute("prices", priceService.getPricesByUser(userName));
        } else {
            model.addAttribute("prices", priceService.getPrices());
        }
        return "prices";
    }
}
