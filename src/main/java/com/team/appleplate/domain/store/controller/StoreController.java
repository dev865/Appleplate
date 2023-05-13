package com.team.appleplate.domain.store.controller;

import com.team.appleplate.domain.store.dto.CreateStoreDto;
import com.team.appleplate.domain.store.dto.StoreDto;
import com.team.appleplate.domain.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/store/{id}")
    public StoreDto.Response getStoreDetail(@PathVariable Long id) {
        return storeService.getStoreDetail(id);
    }

    @PostMapping("/store")
    public ResponseEntity<Void> createStore(@RequestBody @Valid CreateStoreDto.Request request) {
        storeService.createStore(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
