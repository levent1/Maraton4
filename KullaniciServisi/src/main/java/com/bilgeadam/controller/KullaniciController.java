package com.bilgeadam.controller;


import com.bilgeadam.dto.request.RegisterRequestDto;

import com.bilgeadam.repository.entity.Kullanici;
import com.bilgeadam.sevice.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadam.constant.EndPoints.KULLANICI;
import static com.bilgeadam.constant.EndPoints.*;
import static com.bilgeadam.constant.EndPoints.REGISTER;
import static com.bilgeadam.constant.EndPoints.UPDATE;
@RestController
@RequestMapping(KULLANICI)
@RequiredArgsConstructor
public class KullaniciController {
    private  final KullaniciService kullaniciService;

    @PostMapping (REGISTER)
    public ResponseEntity <String> register(@RequestBody RegisterRequestDto dto){

        return ResponseEntity.ok(kullaniciService.register(dto));
    }

    @PostMapping(ACTIVATION)

    public ResponseEntity<String> activation(Long id){
        return ResponseEntity.ok(kullaniciService.activation(id));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<String> login(Long id) {

        return ResponseEntity.ok(kullaniciService.login(id));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Kullanici>> findAll(){
        return ResponseEntity.ok(kullaniciService.findAll());
    }




}
