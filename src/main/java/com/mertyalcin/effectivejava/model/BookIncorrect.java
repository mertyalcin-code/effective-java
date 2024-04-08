package com.mertyalcin.effectivejava.model;

public class BookIncorrect {
    private String isbn;
    private String name;

    public BookIncorrect(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // Yanlış kullanım: Sadece referansları kontrol ediyoruz.
        return this == obj;
    }
}
