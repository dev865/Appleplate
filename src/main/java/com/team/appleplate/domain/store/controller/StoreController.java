package com.team.appleplate.domain.store.controller;

import com.team.appleplate.domain.store.dto.CreateStoreRequestDto;
import com.team.appleplate.domain.store.dto.UpdateStoreRequestDto;
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
    public ResponseEntity<Void> getStoreDetail(@PathVariable Long id) {
        storeService.getStoreDetail(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/store")
    public ResponseEntity<Void> createStore(@RequestBody @Valid CreateStoreRequestDto request) {
        storeService.createStore(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/store/{id}")
    public ResponseEntity<Void> updateStore(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateStoreRequestDto request) {

        storeService.updateStore(id, request);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
