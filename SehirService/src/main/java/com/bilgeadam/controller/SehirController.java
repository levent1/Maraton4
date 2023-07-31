package com.bilgeadam.controller;

import com.bilgeadam.dto.request.SehirRequestDto;
import com.bilgeadam.dto.request.SehirUpdateDto;
import com.bilgeadam.repository.entity.Sehir;
import com.bilgeadam.service.SehirService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadam.constant.EndPoints.*;

@RestController
@RequestMapping(SEHIR)
@RequiredArgsConstructor
public class SehirController {

    private final SehirService sehirService;

    @PostMapping(SAVE)
    public ResponseEntity<String> saveSehir(SehirRequestDto dto){
      return ResponseEntity.ok(sehirService.saveSehir(dto));
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<Sehir>> findall(){
        return ResponseEntity.ok(sehirService.findAll());
    }
    @DeleteMapping(DELETEBYID)
    public ResponseEntity<String> delete(Long id){
        return ResponseEntity.ok(sehirService.deleteSehir(id));
    }

    @GetMapping(UPDATE)
    public  ResponseEntity<String> updateSehir(SehirUpdateDto dto){
        return ResponseEntity.ok(sehirService.updateSehir(dto));
    }





}
