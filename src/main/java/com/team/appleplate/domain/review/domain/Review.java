package com.team.appleplate.domain.review.domain;

import com.team.appleplate.domain.BaseTimeEntity;

import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.store.domain.Store;
import com.team.appleplate.global.util.file.File;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String content;
    private double grade;
    private String completeYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = true)
    private List<File> fileList;

    @Builder
    public Review(String content, double grade, String completeYn, Member member, Store store) {
        this.content = content;
        this.grade = grade;
        this.completeYn = completeYn;
        this.member = member;
        this.store = store;
    }

}
