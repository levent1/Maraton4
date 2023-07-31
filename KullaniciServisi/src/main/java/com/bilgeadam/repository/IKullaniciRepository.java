package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKullaniciRepository  extends JpaRepository<Kullanici,Long> {
}
