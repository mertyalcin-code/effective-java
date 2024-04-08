package com.mertyalcin.effectivejava.rest;

import com.mertyalcin.effectivejava.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generic-demo")
public class GenericController {

    private final GenericService genericService;

    @Autowired
    public GenericController(GenericService genericService) {
        this.genericService = genericService;
    }

    /**
     * Genericlerin raw olarak kullanımının tehlikelerini ve bu kullanımın neden olduğu
     * tür dönüşüm hatalarını gösteren bilgileri döndürür. Ayrıca, genericlerin doğru şekilde
     * kullanımının bu tür sorunları nasıl önlediğini açıklar.
     *
     * @return String - Genericlerin raw ve doğru kullanımı hakkında bilgiler içeren bir metin mesajı.
     */
    @GetMapping("/usage")
    public String getGenericUsageInfo() {
        return genericService.demonstrateGenericUsage();
    }
}
