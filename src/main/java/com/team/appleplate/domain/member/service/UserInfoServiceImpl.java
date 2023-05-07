package com.team.appleplate.domain.member.service;

import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.member.exception.MemberNotFoundException;
import com.team.appleplate.domain.member.repository.MemberRepository;
import com.team.appleplate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void withdrawMember(Long userId) {

        Member findMember = memberRepository.findById(userId).orElseThrow(()->new MemberNotFoundException(ErrorCode.USER_NOT_FOUND));

        findMember.withdrawMember();

    }
}
