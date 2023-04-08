package com.volkan.Java6Mono.repository;

import com.volkan.Java6Mono.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring bir sınıfı ya da interface i yönetmek ve ondan bir nesne yaratmak için
 * belli anatosyonlar kullanır. Repository sınıfları içinde @Repository kullanılır.
 *
 */
@Repository
public interface IMusteriRepository extends JpaRepository<Musteri,Long> {
    /**
     * Burada methodlar için arayüz tanımlanabilir. Spring Data Jpa size bunu sunmaktadır.
     * Spring özel keyword ler ile sorgu yazmanızı sağlar.
     * 1- find: kelimesi ile başlanır.
     * 2- By: ile işlem yapmak istediğiniz bileşeni seçersiniz.
     * 3- [entity-> değişken adı]: kullanılan repository e atanan entity de var olan adını baş harfi büyük olmak
     * kaydıyla yazarsınız.
     * 4- kullanılan method ta özel bir istek keyword varsa eklenir.
     * 5- geri dönüş tipini yazarsınız.
     */
    /**
     * select * from tblmusteri where ad=?
     */
    Musteri findByAd(String ad);
    List<Musteri> findAllByAd(String ad);
    /**
     * DİKKAT!! burada kelimelerin sıralamasına göre parantez içinde istenilen
     * değerler atanır. Yani kelime ad ise parantez içindeki ilk değer ada atanır.
     */

    Musteri findByAdres(String musterinin_adresini_ver);
    Musteri findByAdAndAdres(String ad,String adres);
    Musteri findByAdOrTelefon(String ad,String telefon);
    Musteri findByTelefonAndAdAndAdres(String tel,String ad, String adres);
    List<Musteri> findAllByIl(String il);
    List<Musteri> findAllByAdStartsWith(String ad);
    /**
     * DİKKAT
     * Eğer optional kullanıyorken değer 1 den fazla döner ise hata fırlatır.
     */
    Optional<Musteri> findOptionalByAd(String ad);
    List<Musteri> findByOrderByAd();
    List<Musteri> findByOrderByAdDesc();
    List<Musteri> findTop3ByOrderByAd();
    List<Musteri> findAllByIdIn(List<Long> ids);
    Optional<Musteri> findOptionalByUsernameAndPassword(String username, String password);

}
