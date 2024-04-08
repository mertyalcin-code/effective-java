package com.mertyalcin.effectivejava.rest;

import com.mertyalcin.effectivejava.service.ListFillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/list")
public class ListFillingController {

    private final ListFillingService listFillingService;

    @Autowired
    public ListFillingController(ListFillingService listFillingService) {
        this.listFillingService = listFillingService;
    }

    /**
     * Senkronize olmayan bir şekilde listeyi doldurur ve listenin boyutunu döndürür.
     * 
     * @return Listenin boyutunu içeren bir String mesajı.
     */
    @GetMapping("/fill-not-synchronized")
    public String fillListNotSynchronized() {

        return listFillingService.fillList();
    }

    /**
     * Senkronize bir şekilde listeyi doldurur ve listenin boyutunu döndürür.
     *
     * @return Listenin boyutunu içeren bir String mesajı.
     */
    @GetMapping("/fill-synchronized")
    public String fillListSynchronized() {
        return listFillingService.fillListSynchronized();
    }
}
