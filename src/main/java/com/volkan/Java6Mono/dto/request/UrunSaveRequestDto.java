package com.volkan.Java6Mono.dto.request;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder // Builder, bir sınıftan nesne türetmek için özel oluşturulmuş bir method
@Data // Data,get, set methodlarını tanımlar
@NoArgsConstructor // Parametresiz constructor tanımlar
@AllArgsConstructor // 1....n kadar olan tüm parametreli constructorları tanımlar
public class UrunSaveRequestDto {
    String ad;
    String marka;
    String model;
    Double fiyat;
}
