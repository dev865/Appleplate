package com.team.appleplate.domain.member.service;

import com.team.appleplate.domain.member.dto.MemberResponseDto;
import com.team.appleplate.domain.member.dto.MemberSignupRequestDto;

public interface LoginService {
    MemberResponseDto joinMember(MemberSignupRequestDto MemberJoinRequestDto);
    boolean isDuplicateMember(String memberEmail);
}
