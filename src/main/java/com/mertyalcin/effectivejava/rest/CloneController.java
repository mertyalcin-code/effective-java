package com.mertyalcin.effectivejava.rest;

import com.mertyalcin.effectivejava.service.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clone")
public class CloneController {

    private final CloneService cloneService;

    @Autowired
    public CloneController(CloneService cloneService) {
        this.cloneService = cloneService;
    }

    /**
     * Employee nesnesinin klonlanması ve klonlama işlemi sonrasında ortaya çıkan etkilerin
     * bir HTTP GET isteği üzerinden gösterilmesi.
     * 
     * @return Klonlama sonrası ve değişiklik sonrası tarihlerin karşılaştırılmasını içeren bir String.
     */
    @GetMapping("/demonstrate")
    public String demonstrateCloning() {
        try {
            return cloneService.demonstrateCloning();
        } catch (CloneNotSupportedException e) {
            return "Clone not supported";
        }
    }
}
