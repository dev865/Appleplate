package com.team.appleplate.domain.store.controller;

import com.team.appleplate.domain.store.dto.CreateStoreRequestDto;
import com.team.appleplate.domain.store.dto.StoreResponseDto;
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
    public ResponseEntity<StoreResponseDto> getStoreDetail(@PathVariable Long id) {
        StoreResponseDto storeDetail = storeService.getStoreDetail(id);

        return new ResponseEntity<>(storeDetail, HttpStatus.OK);
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

    @DeleteMapping("/store/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
