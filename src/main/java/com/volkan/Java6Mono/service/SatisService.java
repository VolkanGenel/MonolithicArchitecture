package com.volkan.Java6Mono.service;

import com.volkan.Java6Mono.dto.request.SatisSaveRequestDto;
import com.volkan.Java6Mono.dto.response.MusteriFindAllResponseDto;
import com.volkan.Java6Mono.dto.response.SatisFindAllResponseDto;
import com.volkan.Java6Mono.mapper.IMusteriMapper;
import com.volkan.Java6Mono.mapper.ISatisMapper;
import com.volkan.Java6Mono.repository.ISatisRepository;
import com.volkan.Java6Mono.repository.entity.Musteri;
import com.volkan.Java6Mono.repository.entity.Satis;
import com.volkan.Java6Mono.repository.entity.Urun;
import com.volkan.Java6Mono.repository.view.VwSatis;
import com.volkan.Java6Mono.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SatisService extends ServiceManager<Satis,Long> {

    private final ISatisRepository repository;

    /**
     * @Autowired
     * Spring bu anotasyon ile işaretlenen sınıfların nesnelerini yaratarak
     * ilgili değişkene atamasını yapar. Bean yönetimini böylece sağlamış olur.
     */
    @Autowired
    private MusteriService musteriService;
    @Autowired
    private UrunService urunService;

    public SatisService(ISatisRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<VwSatis> findAllSatisList() {
        List<Satis> satisList = findAll();
        List<Urun> urunList = urunService.findAll();
        List<Musteri> musteriList = musteriService.findAll();
        List<VwSatis> vwSatisList = new ArrayList<>();
        satisList.forEach(x -> {
            String musteriadi = musteriList.stream()
                    .filter(m -> m.getId().equals(x.getMusteriid()))
                    .findFirst().get().getAd();
            String urunadi = urunList.stream()
                    .filter(u -> u.getId().equals(x.getUrunid()))
                    .findFirst().get().getAd();
            VwSatis vwsatis = VwSatis.builder()
                    .satisid(x.getId())
                    .urunid(x.getUrunid())
                    .musteriid(x.getMusteriid())
                    .adet(x.getAdet())
                    .birimfiyat(x.getBirimfiyat())
                    .toplamfiyat(x.getToplamfiyat())
                    .musteriadi(musteriadi)
                    .urunadi(urunadi).build();
            vwSatisList.add(vwsatis);
        });
        return vwSatisList;
    }

    public void saveDto(SatisSaveRequestDto dto) {
        save(ISatisMapper.INSTANCE.toSatis(dto));
    }

    public List<SatisFindAllResponseDto> findAllResponseDtos() {
        List<SatisFindAllResponseDto> result = new ArrayList<>();
        findAll().forEach(x -> {
            //result.add(MusteriFindAllResponseDto.builder()
            //                .ad(x.getAd())
            //                .username(x.getUsername())
            //                .img(x.getImg())
            //        .build());
            result.add(ISatisMapper.INSTANCE.fromSatis(x));
        });
        return result;
    }

    public List<SatisFindAllResponseDto> findAllByMusteriid(Long musteriId) {
            List<SatisFindAllResponseDto> result1 = new ArrayList<>();
            repository.findAllByMusteriid(musteriId).forEach(x->{
                result1.add(ISatisMapper.INSTANCE.fromSatis(x));
            });
            return result1;
    }
}
