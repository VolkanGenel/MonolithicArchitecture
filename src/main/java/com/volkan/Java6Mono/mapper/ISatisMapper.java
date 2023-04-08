package com.volkan.Java6Mono.mapper;

import com.volkan.Java6Mono.dto.request.SatisSaveRequestDto;
import com.volkan.Java6Mono.dto.response.SatisFindAllResponseDto;
import com.volkan.Java6Mono.repository.entity.Satis;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ISatisMapper {
    ISatisMapper INSTANCE = Mappers.getMapper(ISatisMapper.class);
    Satis toSatis(final SatisSaveRequestDto dto);
    SatisFindAllResponseDto fromSatis(final Satis satis);
}
