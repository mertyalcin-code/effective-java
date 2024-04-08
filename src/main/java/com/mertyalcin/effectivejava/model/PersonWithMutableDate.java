package com.mertyalcin.effectivejava.model;

import java.util.Date;

public final class PersonWithMutableDate {
    private final String name;
    private final Date birthDate; // Mutable Date

    public PersonWithMutableDate(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate; // Savunmacı kopyalama yapılmıyor
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate; // Dışarıya doğrudan mutable nesne döndürülüyor
    }
}
