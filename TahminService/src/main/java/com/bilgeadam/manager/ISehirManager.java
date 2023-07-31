package com.bilgeadam.manager;

import com.bilgeadam.repository.entity.Sehir;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.bilgeadam.constant.EndPoints.FINDALL;

@FeignClient(url = "http://localhost:7072/api/v1/sehir",decode404 = true,name = "tahmin-sehire")
public interface   ISehirManager {

    @GetMapping(FINDALL)
    public ResponseEntity<List<Sehir>> findall();
}
