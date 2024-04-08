package com.mertyalcin.effectivejava.service;

import org.springframework.stereotype.Service;

@Service
public class StringConcatenationService {

    /**
     * StringBuilder ve StringBuffer kullanarak 100.000 kere birleştirme işlemi yapar,
     * her bir işlem için geçen süreyi ölçer ve karşılaştırır.
     *
     * @return İki yöntem arasındaki performans karşılaştırmasını içeren bir String mesajı döndürür.
     */
    public String compareStringBuilders() {
        // StringBuilder ile zaman ölçümü
        long startTimeStringBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("someText");
        }
        long endTimeStringBuilder = System.nanoTime();
        long durationStringBuilder = endTimeStringBuilder - startTimeStringBuilder;

        // StringBuffer ile zaman ölçümü
        long startTimeStringBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append("someText");
        }
        long endTimeStringBuffer = System.nanoTime();
        long durationStringBuffer = endTimeStringBuffer - startTimeStringBuffer;

        // Sonuçların döndürülmesi
        return "StringBuilder time: " + durationStringBuilder + " nanoseconds\n" +
                "StringBuffer time: " + durationStringBuffer + " nanoseconds\n" +
                "Difference: " + (durationStringBuffer - durationStringBuilder) + " nanoseconds (StringBuffer - StringBuilder)";
    }
}
