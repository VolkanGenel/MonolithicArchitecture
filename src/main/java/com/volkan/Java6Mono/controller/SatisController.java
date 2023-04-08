package com.volkan.Java6Mono.controller;


import com.volkan.Java6Mono.dto.request.SatisSaveRequestDto;
import com.volkan.Java6Mono.dto.response.SatisFindAllResponseDto;
import com.volkan.Java6Mono.repository.entity.Musteri;
import com.volkan.Java6Mono.repository.entity.Satis;
import com.volkan.Java6Mono.service.SatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.volkan.Java6Mono.constants.EndPoints.*;

@RestController
//localhost:9090/satis
@RequestMapping(API+VERSION+SATIS)
@RequiredArgsConstructor
public class SatisController {
    private final SatisService satisService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(SatisSaveRequestDto dto) {
        satisService.saveDto(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Satis>> findAll() {
        return ResponseEntity.ok(satisService.findAll());
    }

    @GetMapping("/mahmut")
    public ResponseEntity<List<SatisFindAllResponseDto>> findAllByMusteriid(Long musteriId) {
        return ResponseEntity.ok((satisService.findAllByMusteriid(musteriId)));
    }

}
