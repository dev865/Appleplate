package com.team.appleplate.global.util.file;

import com.team.appleplate.domain.BaseTimeEntity;
import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.review.domain.Review;
import com.team.appleplate.domain.store.domain.Store;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class File extends BaseTimeEntity {

    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long fileNo;
    private String savePath;
    private String originalFileName;
    private String fileName;

    @Builder
    public File(final Long fileNo, final String savePath, final String originalFileName, final String fileName){
        this.fileNo = fileNo;
        this.savePath = savePath;
        this.originalFileName = originalFileName;
        this.fileName = fileName;
    }


    }
}
