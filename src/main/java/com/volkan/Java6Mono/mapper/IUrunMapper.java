package com.volkan.Java6Mono.mapper;

import com.volkan.Java6Mono.dto.request.UrunSaveRequestDto;
import com.volkan.Java6Mono.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IUrunMapper {
    IUrunMapper INSTANCE = Mappers.getMapper(IUrunMapper.class);
    Urun toUrun(final UrunSaveRequestDto dto);
}
