package com.team.appleplate.domain.member.controller;

import com.team.appleplate.domain.member.dto.MemberResponseDto;
import com.team.appleplate.domain.member.dto.MemberSignupRequestDto;
import com.team.appleplate.domain.member.service.LoginService;
import io.swagger.annotations.ApiOperation;
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

    @PostMapping("/signup")
    @ApiOperation(value = "회원가입 기능",notes = "name, email, password를 입력받아 회원가입")
    public ResponseEntity<MemberResponseDto> signupMember(@Valid @RequestBody MemberSignupRequestDto signupRequest){

        MemberResponseDto memberResponseDto = loginService.signupMember(signupRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(memberResponseDto.getId())
                .toUri();

       return ResponseEntity.created(location).build();

    }

}