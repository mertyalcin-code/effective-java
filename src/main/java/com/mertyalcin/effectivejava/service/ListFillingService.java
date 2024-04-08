package com.mertyalcin.effectivejava.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ListFillingService {

    private List<Integer> sharedList = new ArrayList<>();
    private List<Integer> sharedListSynchronized = new ArrayList<>();

    /**
     * Birden fazla thread tarafından eş zamanlı olarak çalıştırılan bir metod.
     * Bu metod, belirli bir aralıkta sayıları listeye ekler.
     */
    public String fillList() {
        sharedList = new ArrayList<>(); // Her çağrıda liste yeniden başlatılır
        Thread[] threads = new Thread[100]; // 100 thread oluştur
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) { // Her thread için 100 eleman ekle
                    sharedList.add(j);
                }
            });
            threads[i].start(); // Thread'i başlat
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Tüm thread'lerin bitmesini bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Listede beklenen eleman sayısı: " + (100 * 10000) +
                ". Gerçekte doldurulan eleman sayısı: " + sharedList.size() + ".";
    }

    /**
     * Listeyi senkronize bir şekilde doldurur.
     * Eş zamanlı erişim sırasında veri tutarlılığını sağlar.
     */
    public String fillListSynchronized() {
        sharedListSynchronized = new ArrayList<>(); // Her çağrıda liste yeniden başlatılır
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronized (sharedListSynchronized) { // Listeye erişimi senkronize eder
                        sharedListSynchronized.add(j);
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Tüm thread'lerin bitmesini bekle
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Mevcut thread'i kesintiye uğrat
                throw new RuntimeException(e);
            }
        }
        return "Listede beklenen eleman sayısı: " + (100 * 10000) +
                ". Gerçekte doldurulan eleman sayısı: " + sharedListSynchronized.size() + ".";
    }
}

