package com.bilgeadam.sevice;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.excepiton.ErrorType;
import com.bilgeadam.excepiton.KullaniciManagerException;
import com.bilgeadam.mapper.IKullaniciMapper;
import com.bilgeadam.repository.IKullaniciRepository;
import com.bilgeadam.repository.entity.Kullanici;
import com.bilgeadam.repository.enums.EDurum;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KullaniciService extends ServiceManager <Kullanici,Long> {
    private final IKullaniciRepository kullaniciRepository;

    public KullaniciService(IKullaniciRepository kullaniciRepository) {
        super(kullaniciRepository);
        this.kullaniciRepository = kullaniciRepository;
    }

    public String register(RegisterRequestDto dto) {
        Kullanici kullanici = IKullaniciMapper.INSTANCE.toKullanici(dto);
        kullanici.setDurum(EDurum.PASIF);
        try {
            save(kullanici);
        } catch (Exception e) {
            throw new KullaniciManagerException(ErrorType.BAD_REQUEST);
        }
        return "Kullanıcı başarı ile kayıt edilmiştir idsi:" + kullanici.getId();
    }

    public String activation(Long id) {
        Optional<Kullanici> kullanici = findById(id);

        if (kullanici.isEmpty()) {
            new KullaniciManagerException(ErrorType.USER_NOT_FOUND);
        }
        kullanici.get().setDurum(EDurum.AKTIF);
        save(kullanici.get());

        return "Aktifleştirme işlemi başarı ile sağlanmıştır";
    }

    public String login(Long id) {
        Optional<Kullanici> kullanici = findById(id);
        if (kullanici.get().getDurum().equals(EDurum.AKTIF)) {
            kullanici.get().setDurum(EDurum.LOGIN);
        }
        if ((!kullanici.get().getDurum().equals(EDurum.AKTIF)) || (!kullanici.get().getDurum().equals(EDurum.AKTIF))) {
            new KullaniciManagerException(ErrorType.STATUS_NOT_AVAILABLE);
        }
        return "Kullanıcı login işlemi başarılı";
    }

}

