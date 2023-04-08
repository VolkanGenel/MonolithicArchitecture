package com.volkan.Java6Mono.mapper;

import com.volkan.Java6Mono.dto.request.MusteriSaveRequestDto;
import com.volkan.Java6Mono.dto.response.MusteriFindAllResponseDto;
import com.volkan.Java6Mono.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Heer framework ve uygulama için nesne yaratma ve işleme mekanizmaları farklıdır bu nedenle
 * SpringBoot için Mapper kullanılacak ise Model olarak spring kullanılacağı belirtilmelidir.
 * TargetPolicy -> Eşleştirme yapılacak ikii bileşen(Object) birebir birbirine uymayabilir,
 * bu nedenle eşleştirme yaparken istisna fırlatır. İşte bu noktada eşleşmeyen alanların
 * görmezden gelinmesi için IGNORE kullanmak mantıklı olacaktır.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMusteriMapper {
    /**
     * Bu interface den bir nesne yaratmak için kullanılır.
     */
    IMusteriMapper INSTANCE = Mappers.getMapper(IMusteriMapper.class);

    /**
     * Buradan itibaren dönüşüm yapmak istediğimiz sınıflara ait methodlar tanımlıyoruz.
     * DİKKATTT!!!!
     * burada yazılan methodun adının ve kullanılan keywordlerin bir önemi yoktur.
     */
    Musteri fromMusteriSaveRequestDto(final MusteriSaveRequestDto dto);
    MusteriFindAllResponseDto fromMusteri(final Musteri musteri);
}
