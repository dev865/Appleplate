package com.team.appleplate.domain.member.domain;

import com.team.appleplate.domain.BaseTimeEntity;
import com.team.appleplate.global.util.file.File;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String memberName;
    private String password;
    private char holicYn;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<File> fileList = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private SocialType socialType;
    private String socialId;
    private char actYn;

    @Builder(builderClassName = "UserDetailRegister", builderMethodName ="userDetailRegister" )
    public Member(final String email, final String memberName, final String password){

        Assert.notNull(memberName, "유저 이름은 필수입니다");
        Assert.notNull(email, "유저 이메일은 필수입니다");

        this.email = email;
        this.memberName = memberName;
        this.password = password;
        this.holicYn = 'N';
        this.role = Role.USER;
        this.socialType = SocialType.applePlate;
        this.actYn = 'Y';
    }

    @Builder(builderClassName = "OAuth2Register", builderMethodName = "oauth2Register")
    public Member(final String email, final String memberName, final SocialType socialType,
                  final String socialId) {

        this.email      = email;
        this.memberName = memberName;
        this.holicYn    = 'N';
        this.role       = Role.USER;
        this.socialType = socialType;
        this.actYn      = 'Y';
        this.socialId   = socialId;

    }

    public void withdrawMember(){
        this.actYn = 'N';
    }
}
