package com.bilgeadam.service;

import com.bilgeadam.dto.request.SehirRequestDto;
import com.bilgeadam.dto.request.SehirUpdateDto;
import com.bilgeadam.mapper.ISehirMapper;
import com.bilgeadam.repository.ISehirRepository;
import com.bilgeadam.repository.entity.Sehir;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SehirService extends ServiceManager<Sehir,Long> {
    private  final ISehirRepository sehirRepository;


    public SehirService( ISehirRepository sehirRepository) {
        super(sehirRepository);
        this.sehirRepository = sehirRepository;
    }

    public String saveSehir(SehirRequestDto dto){

        Sehir sehir= ISehirMapper.INSTANCE.toSehir(dto);
        save(sehir);
        return "Sehir kayıt işlemi başarıyla gerçekleşmiştir id no:"+sehir.getId();
    }

    public String deleteSehir(Long id) {
      Optional<Sehir> sehir=findById(id);
        deleteById(id);
        return "Şehir silme işlemi başarılı olmuştur.Silinen şehir id:"+sehir.get().getId();
    }

    public String updateSehir(SehirUpdateDto dto) {
      Optional<Sehir> sehir=findById(dto.getId());
      sehir.get().setAd(dto.getAd());
      sehir.get().setBolge(dto.getBolge());
      sehir.get().setKopaya(dto.getKopaya());
      save(sehir.get());
      return "Güncelleme işlemi başarıyla gerçekleşmiştir";

    }
}
