package com.mertyalcin.effectivejava.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GenericService {

    /**
     * Genericlerin raw (ham) olarak kullanımının neden olabileceği tür güvenliği problemlerini gösterir.
     * Bu metod, öncelikle bir List'i raw olarak kullanır ve ardından generic versiyonunu kullanarak
     * aynı işlemi güvenli bir şekilde nasıl yapabileceğimizi gösterir. Raw kullanım sırasında oluşabilecek
     * tür dönüşüm hatalarını ve nasıl önlenebileceğini açıklar.
     *
     * @return String - Raw kullanımın tehlikeleri ve genericlerin doğru kullanımı hakkında bilgi içeren bir metin mesajı.
     */
    public String demonstrateGenericUsage() {
        // Raw olarak kullanım
        List rawList = new ArrayList();
        rawList.add("string");
        rawList.add(10); // Bu satır runtime'da ClassCastException'a neden olabilir.

        String result = "Raw List Kullanımı: List'e herhangi bir tür eklenebilir, bu da tip güvensizliğine yol açar.\n";

        try {
            for (Object item : rawList) {
                String stringItem = (String) item; // Bu dönüşüm ClassCastException'a neden olabilir.
            }
        } catch (ClassCastException e) {
            result += "ClassCastException oluştu: Bu, raw kullanımın tehlikelerini gösterir.\n";
        }

        // Generic ile kullanım
        List<String> genericList = new ArrayList<>();
        genericList.add("string");
        // genericList.add(10); // Bu satır compile time'da hata verir.

        result += "Generic List Kullanımı: List'e sadece String türünden objeler eklenebilir, bu da tür güvenliğini sağlar.";

        return result;
    }
}
