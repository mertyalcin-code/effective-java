package com.mertyalcin.effectivejava.rest;

import com.mertyalcin.effectivejava.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * `equals` metodunun yanlış ve doğru kullanımını gösteren bir bilgi mesajını döndürür.
     * Bu endpoint, `BookService` tarafından sağlanan açıklamayı bir HTTP GET isteği üzerinden sunar.
     *
     * @return String - `equals` metodunun kullanımıyla ilgili bilgiler içeren bir metin mesajı.
     */
    @GetMapping("/equals-usage")
    public String getEqualsUsageInfo() {
        return bookService.demonstrateEqualsUsage();
    }
}
