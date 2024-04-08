package com.mertyalcin.effectivejava.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class CurrencyService {
    private double balanceDouble = 1.03; // double türünde bakiye
    private BigDecimal balanceBigDecimal = BigDecimal.valueOf(1.03); // BigDecimal türünde bakiye

    /**
     * Belirli bir miktarı double olarak bakiyeden çeker ve yeni bakiyeyi döndürür.
     *
     * @param amount Çekilecek miktar (double)
     * @return Yeni bakiyeyi içeren String türünde mesaj
     */
    public String withdrawMoneyWithDouble(double amount) {
        if (amount > 0) {
            balanceDouble -= amount;
            return "Yeni bakiyeniz (double):" + balanceDouble;
        } else {
            return "Çekilecek miktar sıfırdan büyük olmalıdır.";
        }
    }

    /**
     * Belirli bir miktarı BigDecimal olarak bakiyeden çeker ve yeni bakiyeyi döndürür.
     *
     * @param amount Çekilecek miktar (BigDecimal)
     * @return Yeni bakiyeyi içeren String türünde mesaj
     */
    public String withdrawMoneyWithBigDecimal(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balanceBigDecimal = balanceBigDecimal.subtract(amount);
            return "Yeni bakiyeniz (BigDecimal):" + balanceBigDecimal;
        } else {
            return "Çekilecek miktar sıfırdan büyük olmalıdır.";
        }
    }
}

