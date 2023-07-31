package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Tahmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITahminRepository extends JpaRepository<Tahmin,Long> {
}
