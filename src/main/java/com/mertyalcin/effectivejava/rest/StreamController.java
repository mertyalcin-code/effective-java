package com.mertyalcin.effectivejava.rest;

import com.mertyalcin.effectivejava.service.StreamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stream")
public class StreamController {
    private final StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    /**
     * Stream aracılığıyla bir koleksiyon oluşturup süresini dönüyor
     *
     * @return Oluşturulma süresini içeren bir String mesajı.
     */
    @GetMapping("/bad")
    public String badMethod() {
        return streamService.runBadMethod();
    }
    /**
     * Stream aracılığıyla bir koleksiyon oluşturup süresini dönüyor
     *
     * @return Oluşturulma süresini içeren bir String mesajı.
     */
    @GetMapping("/good")
    public String goodMethod() {
        return streamService.runGoodMethod();
    }
}
