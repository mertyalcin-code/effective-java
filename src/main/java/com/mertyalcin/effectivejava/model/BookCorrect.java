package com.mertyalcin.effectivejava.model;

public class BookCorrect {
    private String isbn;
    private String name;

    public BookCorrect(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        BookCorrect book = (BookCorrect) obj;
        
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        return name != null ? name.equals(book.name) : book.name == null;
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
