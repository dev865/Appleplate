package com.team.appleplate.domain.review.domain;

import com.team.appleplate.domain.BaseTimeEntity;

import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.store.domain.Store;
import com.team.appleplate.global.util.file.File;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> fileList = new ArrayList<>();

    @Builder
    public Review(String content, double grade, String completeYn, Member member, Store store) {
        this.content = content;
        this.grade = grade;
        this.completeYn = completeYn;
        this.member = member;
        this.store = store;
    }

    /**
     * 리뷰의 fileList 저장 후 file.Review 저장
     */
    public void addFile(File file){
        this.fileList.add(file);

        if(file.getReview() != this){
            file.addReview(this);
        }
    }

}
