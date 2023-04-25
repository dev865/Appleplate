package com.team.appleplate.domain.member.controller;

import com.team.appleplate.domain.member.dto.MemberResponseDto;
import com.team.appleplate.domain.member.dto.MemberSignupRequestDto;
import com.team.appleplate.domain.member.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Validated
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/join")
    public ResponseEntity<MemberResponseDto> joinMember(@Valid @RequestBody MemberSignupRequestDto memberRequestDto){

        MemberResponseDto memberResponseDto = loginService.joinMember(memberRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(memberResponseDto.getId())
                .toUri();

       return ResponseEntity.created(location).build();

    }

}