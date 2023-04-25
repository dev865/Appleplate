package com.team.appleplate.domain.member.dto;

import com.team.appleplate.domain.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class MemberSignupRequestDto {

    @NotBlank(message = "이메일은 필수값입니다")
    @Email(message = "Email 형식이 아닙니다")
    private final String email;
    @NotBlank
    private final String memberName;
    @NotBlank
    @Setter
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수문자가 적어도 1개 이상씩 포함된 8~20자의 비밀번호여야합니다.")
    private String password;

    public MemberSignupRequestDto(final String email, final String memberName, final String password){
        this.email = email;
        this.memberName = memberName;
        this.password = password;
    }

    public Member toEntity(){
        return Member.userDetailRegister()
                .memberName(memberName)
                .email(email)
                .password(password)
                .build();
    }
}
