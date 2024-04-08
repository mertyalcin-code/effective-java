package com.mertyalcin.effectivejava.service;

import com.mertyalcin.effectivejava.model.PersonWithImmutableDate;
import com.mertyalcin.effectivejava.model.PersonWithMutableDate;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class PersonService {

    /**
     * PersonWithMutableDate ve PersonWithImmutableDate sınıflarının doğum tarihlerinin
     * dışarıdan nasıl değiştirilebildiğini (veya değiştirilemediğini) gösterir.
     * 
     * @return İki durumun sonuçlarını açıklayan bir String mesajı döndürür.
     */
    public String demonstrateDateImmutability() {
        Date birthDate1 = new Date(); // Mevcut Tarih
        Date birthDate2 = new Date(); // Mevcut Tarih

        // Mutable sınıf örneği
        PersonWithMutableDate mutablePerson = new PersonWithMutableDate("John Doe", birthDate1);
        Date mutableBirthDate = mutablePerson.getBirthDate();
        mutableBirthDate.setTime(birthDate1.getTime() + 1000000000); // Doğum tarihini değiştir

        // Immutable sınıf örneği
        PersonWithImmutableDate immutablePerson = new PersonWithImmutableDate("Jane Doe", birthDate2);
        Date immutableBirthDate = immutablePerson.getBirthDate();
        immutableBirthDate.setTime(birthDate2.getTime() + 1000000000); // Bu değişiklik etkili olmamalı

        // Sonuçların döndürülmesi
        return "Mutable sınıfın değişim sonrası yeni doğum tarihi: " + mutablePerson.getBirthDate() +
                "\nImmutable sınıfın değişim sonrası yeni doğum tarihi " + immutablePerson.getBirthDate();
    }
}

