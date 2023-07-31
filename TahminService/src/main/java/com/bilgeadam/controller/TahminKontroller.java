package com.bilgeadam.controller;


import com.bilgeadam.Service.TahminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bilgeadam.constant.EndPoints.SOR;
import static com.bilgeadam.constant.EndPoints.TAHMIN;

@RestController
@RequestMapping(TAHMIN)
@RequiredArgsConstructor
public class TahminKontroller {

    private final TahminService tahminService;

    //Kurgumuzda  kullanıcı önce soru için istek atıyor sonra cevaplaını istek atıyor hesaplıyor cevabı skor service gidip değerlendirilip geri dönüyor

    @PostMapping(SOR)
    public ResponseEntity<String> sor(){
        return  ResponseEntity.ok(tahminService.sor());
    }









}
