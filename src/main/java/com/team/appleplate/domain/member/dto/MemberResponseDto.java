package com.team.appleplate.domain.member.dto;

import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.member.domain.Role;
import com.team.appleplate.domain.member.domain.SocialType;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private final Long id;
    private final String email;
    private final String memberName;
    private final char holicYn;
    private final Role role;
    private final SocialType socialType;

    public MemberResponseDto(Member entity){
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.memberName = entity.getMemberName();
        this.holicYn = entity.getHolicYn();
        this.role = entity.getRole();
        this.socialType = entity.getSocialType();
    }
}
