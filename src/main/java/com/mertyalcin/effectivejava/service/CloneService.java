package com.mertyalcin.effectivejava.service;

import com.mertyalcin.effectivejava.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CloneService {

    /**
     * Employee nesnesinin klonlanmasını sağlar ve klonlama işleminin etkilerini gösterir.
     * Yüzeysel kopyalama nedeniyle, klonlanmış nesnenin startDate alanında yapılan değişiklikler
     * orijinal nesneyi de etkiler.
     *
     * @return Klonlama sonrası ve değişiklik sonrası tarihlerin karşılaştırılmasını içeren bir String.
     * @throws CloneNotSupportedException Eğer clone metodu desteklenmiyorsa.
     */
    public String demonstrateCloning() throws CloneNotSupportedException {
        Employee original = new Employee("John Doe", new Date());
        Employee cloned = (Employee) original.clone();

        // Klonlanmış nesnenin startDate alanını değiştirme
        cloned.getStartDate().setTime(System.currentTimeMillis() + 1000000000);

        // Orijinal ve klonlanmış nesnelerin startDate alanlarını karşılaştırma
        return "Original Start Date: " + original.getStartDate() + "\n" +
               "Cloned Start Date: " + cloned.getStartDate();
    }
}
