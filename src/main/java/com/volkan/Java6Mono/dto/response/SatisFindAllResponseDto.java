package com.volkan.Java6Mono.dto.response;

import lombok.*;


@Builder // Builder, bir sınıftan nesne türetmek için özel oluşturulmuş bir method
@Data // Data,get, set methodlarını tanımlar
@NoArgsConstructor // Parametresiz constructor tanımlar
@AllArgsConstructor // 1....n kadar olan tüm parametreli constructorları tanımlar
public class SatisFindAllResponseDto {
    Long musteriid;
    Long urunid;
    Long tarih;
    int adet;
    Double birimfiyat;
    Double toplamfiyat;
}
