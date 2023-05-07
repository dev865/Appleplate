package com.team.appleplate.domain.member.controller;

import com.team.appleplate.domain.member.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @DeleteMapping("/withdraw/{userId}")
    public ResponseEntity<Void> withdrawMember(@PathVariable Long userId){

        userInfoService.withdrawMember(userId);

        return ResponseEntity.noContent().build();
    }
}
