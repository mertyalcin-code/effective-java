package com.mertyalcin.effectivejava.rest;

import com.mertyalcin.effectivejava.service.StringConcatenationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/string-concenation")
public class StringConcenationController {

    private final StringConcatenationService stringConcenationService;

    @Autowired
    public StringConcenationController(StringConcatenationService stringConcenationService) {
        this.stringConcenationService = stringConcenationService;
    }

    @GetMapping()
    public String compareStringBuilders() {
        return stringConcenationService.compareStringBuilders();
    }
}
