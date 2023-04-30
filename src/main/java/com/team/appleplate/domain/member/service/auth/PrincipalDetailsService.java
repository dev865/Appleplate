package com.team.appleplate.domain.member.service.auth;

import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.member.domain.PrincipalDetails;
import com.team.appleplate.domain.member.dto.MemberResponseDto;
import com.team.appleplate.domain.member.dto.MemberSignupRequestDto;
import com.team.appleplate.domain.member.exception.MemberDuplicateException;
import com.team.appleplate.domain.member.exception.MemberNotFoundException;
import com.team.appleplate.domain.member.repository.MemberRepository;
import com.team.appleplate.domain.member.service.LoginService;
import com.team.appleplate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService, LoginService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(userEmail);

        if(member == null){
           throw new MemberNotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        return new PrincipalDetails(member);
    }

    @Override
    public MemberResponseDto signupMember(MemberSignupRequestDto signupRequest){

        if(isDuplicateMember(signupRequest.getEmail())){
            throw new MemberDuplicateException(ErrorCode.DUPLICATE_ACCOUNT);
        }

        signupRequest.setPassword(encoder.encode(signupRequest.getPassword()));
        Member member = memberRepository.save(signupRequest.toEntity());
        return new MemberResponseDto(member);

    }

    @Override
    public boolean isDuplicateMember(String memberEmail) {

        Member member = memberRepository.findByEmail(memberEmail);
        if(member == null){
            return false;
        }
        return true;

    }

}
