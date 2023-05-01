package com.team.appleplate.domain.member.service.auth;

import com.team.appleplate.domain.member.domain.*;

import com.team.appleplate.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;

    public OAuth2User loadUser(final OAuth2UserRequest userRequest){

        OAuth2User      oAuth2User      = super.loadUser(userRequest);
        OAuth2UserInfo  oAuth2UserInfo  = new KakaoUserInfo(oAuth2User.getAttributes());
        String email  = oAuth2UserInfo.getEmail();
        Member member = memberRepository.findByEmail(email);

        //DB에 없는 사용자라면 회원가입처리
        if(member == null){
            member = Member.oauth2Register()
                    .memberName(oAuth2UserInfo.getName())
                    .email(email)
                    .socialType(SocialType.kakao)
                    .socialId(oAuth2UserInfo.getProviderId())
                    .build();
            memberRepository.save(member);
        }
        return new PrincipalDetails(member, oAuth2User.getAttributes());
    }
}


