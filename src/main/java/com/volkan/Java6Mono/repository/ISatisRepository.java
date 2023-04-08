package com.volkan.Java6Mono.repository;

import com.volkan.Java6Mono.repository.entity.Satis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
    /**
    * ------------------------
             * Sorgu
             * 1- Kime Ne satıldı listesi
             * 2- A kişisine neler satıldı listesi
             * 3- En çok satış adedi olan müşteri
             * 4- En çok satılan 3 ürün
     */
@Repository
public interface ISatisRepository extends JpaRepository<Satis,Long> {
    List<Satis> findAllByMusteriid(Long id);

    /**
     * 3- En çok satis adedi olan Musteri
     * - hangi müşteri ne kadar ürün satın almış
     * select musteriid, SUM(adet) from tblmusteri group by musteriid
     * -en çok satışı olan müşteri
     * select musteriid from tblmusteri group by musteriid order by SUM(adet) desc top 1
     */

    @Query(value="select s.musteriid from Satis s group by s.musteriid order by SUM(s.adet) desc limit 1",
            nativeQuery = true)
    Long findBySumSatisAdet();

    @Query(value="select s.urunid from Satis s group by s.urunid order by SUM(s.adet) desc limit 3",
            nativeQuery = true)
    List<Long> findAllBySatisAdet();

}
