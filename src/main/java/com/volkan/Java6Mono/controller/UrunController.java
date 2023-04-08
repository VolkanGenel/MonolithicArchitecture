package com.volkan.Java6Mono.controller;

import static com.volkan.Java6Mono.constants.EndPoints.*;
import com.volkan.Java6Mono.dto.request.UrunSaveRequestDto;
import com.volkan.Java6Mono.exception.EErrorType;
import com.volkan.Java6Mono.exception.SatisManagerException;
import com.volkan.Java6Mono.repository.entity.Urun;
import com.volkan.Java6Mono.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(API+VERSION+URUN)
@RequiredArgsConstructor
public class UrunController {
    private final UrunService urunService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(UrunSaveRequestDto dto) {
        urunService.saveDto(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Urun>> findAll() {
        return ResponseEntity.ok(urunService.findAll());
    }

    /**
     * localhost:9090/api/v1/urun/getbyad?ad=muhammet
     * @param ad
     * @return
     * @throws Exception
     */
    @GetMapping("/getbyad")
    public ResponseEntity<String> getAllByAd(String ad) throws Exception {
        if(ad==null)
            throw new SatisManagerException(EErrorType.URUN_EKLEME,"Ürün eklemede ad bilgisi boş geldiği için hata oluştu");
        return ResponseEntity.ok("Her şey yolunda");
    }
}
