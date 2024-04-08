package com.mertyalcin.effectivejava.service;

import com.mertyalcin.effectivejava.model.BookCorrect;
import com.mertyalcin.effectivejava.model.BookIncorrect;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    /**
     * `BookIncorrect` ve `BookCorrect` sınıflarının nesneleri üzerinden `equals` metodunun
     * yanlış ve doğru kullanımını gösterir. Bu metod, iki farklı kitap örneği oluşturur:
     * biri yanlış `equals` kullanımını temsil ederken, diğeri doğru kullanımı temsil eder.
     * Daha sonra, her iki durumda da kitap nesnelerini karşılaştırır ve sonuçları bir String olarak döndürür.
     * Yanlış kullanımda, `equals` metodunun referans eşitliğini kontrol ettiği,
     * doğru kullanımda ise nesnelerin değerlerine (isbn ve isim) göre eşit olup olmadıklarını kontrol ettiği gösterilir.
     *
     * @return String - `equals` metodunun yanlış ve doğru kullanımlarının sonuçlarını içeren bir metin mesajı.
     * Bu mesaj, her iki senaryonun beklenen ve gerçek sonuçlarını açıklar.
     */
    public String demonstrateEqualsUsage() {
        // Yanlış kullanım için örnek kitaplar
        BookIncorrect book1Incorrect = new BookIncorrect("123456789", "Java Basics");
        BookIncorrect book2Incorrect = new BookIncorrect("123456789", "Java Basics");

        // Doğru kullanım için örnek kitaplar
        BookCorrect book1Correct = new BookCorrect("123456789", "Java Basics");
        BookCorrect book2Correct = new BookCorrect("123456789", "Java Basics");

        // Yanlış kullanımın sonuçları
        boolean resultIncorrect = book1Incorrect.equals(book2Incorrect);

        // Doğru kullanımın sonuçları
        boolean resultCorrect = book1Correct.equals(book2Correct);

        return "Yanlış Kullanım Sonucu: " + resultIncorrect + " (Beklenen: false, Gerçek: false, çünkü referanslar farklı)\n" +
                "Doğru Kullanım Sonucu: " + resultCorrect + " (Beklenen: true, Gerçek: true, çünkü ISBN ve isimler aynı)";
    }
}
