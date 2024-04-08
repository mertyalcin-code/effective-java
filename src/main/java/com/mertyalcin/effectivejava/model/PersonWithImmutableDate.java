package com.mertyalcin.effectivejava.model;

import java.util.Date;

public final class PersonWithImmutableDate {
    private final String name;
    private final Date birthDate;

    public PersonWithImmutableDate(String name, Date birthDate) {
        this.name = name;
        this.birthDate = new Date(birthDate.getTime()); // Savunmacı kopyalama
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return new Date(birthDate.getTime()); // Savunmacı kopyalama ile dışarıya ver
    }
}
