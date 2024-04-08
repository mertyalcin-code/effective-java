package com.mertyalcin.effectivejava.rest;

import java.math.BigDecimal;

import com.mertyalcin.effectivejava.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/withdraw-with-double")
    public String withdrawMoneyWithDouble(@RequestParam double amount) {
        return currencyService.withdrawMoneyWithDouble(amount);
    }

    @GetMapping("/withdraw-with-big-decimal")
    public String withdrawMoneyWithBigDecimal(@RequestParam BigDecimal amount) {
        return currencyService.withdrawMoneyWithBigDecimal(amount);
    }
}
