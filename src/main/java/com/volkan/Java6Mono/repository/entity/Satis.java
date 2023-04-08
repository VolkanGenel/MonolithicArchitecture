package com.volkan.Java6Mono.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder // Builder, bir sınıftan nesne türetmek için özel oluşturulmuş bir method
@Data // Data,get, set methodlarını tanımlar
@NoArgsConstructor // Parametresiz constructor tanımlar
@AllArgsConstructor // 1....n kadar olan tüm parametreli constructorları tanımlar
@ToString // sınıf için toString methodunu tanımlar
@Entity
@Table(name = "tblsatis")
public class Satis {
    /**
     * Ne zaman
     * Kime
     * Ne kadar
     * Ne satıldı?
     * ------------------------
     * Sorgu
     * 1- Kime Ne satıldı listesi
     * 2- A kişisine neler satıldı listesi
     * 3- En çok satış adedi olan müşteri
     * 4- En çok satılan 3 ürün
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    Long urunid;
    Long tarih;
    int adet;
    Double birimfiyat;
    Double toplamfiyat;

}
