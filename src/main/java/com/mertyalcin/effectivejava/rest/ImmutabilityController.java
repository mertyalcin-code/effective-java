package com.mertyalcin.effectivejava.rest;

import com.mertyalcin.effectivejava.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/immutability")
public class ImmutabilityController {

    private final PersonService personService;

    @Autowired
    public ImmutabilityController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * PersonWithMutableDate ve PersonWithImmutableDate sınıflarının
     * doğum tarihlerinin dışarıdan nasıl değiştirilebildiğini (veya değiştirilemediğini)
     * gösteren bir HTTP GET isteği işler.
     * 
     * @return İki durumun sonuçlarını açıklayan bir String mesajı.
     */
    @GetMapping("/demonstrate-date-immutability")
    public String demonstrateDateImmutability() {
        return personService.demonstrateDateImmutability();
    }
}
