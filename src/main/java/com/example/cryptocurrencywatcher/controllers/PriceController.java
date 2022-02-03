package com.example.cryptocurrencywatcher.controllers;

import com.example.cryptocurrencywatcher.services.CurrencyPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private CurrencyPricesService currencyPricesService;

//    @GetMapping
//    public String getPrices(Model model) {
//        model.addAttribute("prices", currencyPriceService);
//        return "prices";
//    }
}
