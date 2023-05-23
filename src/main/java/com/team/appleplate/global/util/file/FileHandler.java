package com.team.appleplate.global.util.file;

import com.team.appleplate.global.util.file.dto.FileResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileHandler {
    /**
     * List<MultipartFile>의 File엔티티화 및 프로젝트내 폴더에 저장
     * Parameter() : List<MultipartFile>
     * 저장 경로 : /images
     */
    public FileResponseDto parseFileInfo(List<MultipartFile> multipartFiles) {
        // FileResponseDto에 담길 fileList
        List<File> fileList = new ArrayList<>();

        // 전달되어 온 파일이 존재할 경우
        if(!CollectionUtils.isEmpty(multipartFiles)) {
            // 날짜별로 폴더 구분
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String current_date = now.format(dateTimeFormatter);

            // 프로젝트 디렉터리 내의 저장을 위한 절대 경로 설정  [appleplate 프로젝트의 위치]
            String absolutePath = new java.io.File("").getAbsolutePath() + java.io.File.separator;

            // 파일을 저장할 세부 경로 지정 예시) /images/20230523
            String path = "images" + java.io.File.separator + current_date;

            java.io.File fileWithPath = new java.io.File(path);

            // 디렉터리가 존재하지 않을 경우
            if(!fileWithPath.exists()) {
                boolean wasSuccessful = fileWithPath.mkdirs();

                // 디렉터리 생성에 실패했을 경우
                if(!wasSuccessful)
                    System.out.println("file: was not successful");
            }

            // 다중 파일 처리
            for(int i=0; i < multipartFiles.size(); i++) {
                // 파일리스트 index
                MultipartFile multipartFile = multipartFiles.get(i);
                // 파일의 확장자 추출
                String originalFileExtension;
                String contentType = multipartFile.getContentType();

                // 확장자명이 존재하지 않을 경우 처리 x
                if(ObjectUtils.isEmpty(contentType)) {
                    break;
                }
                else {  // 확장자가 jpeg, png인 파일들만 받아서 처리
                    if(contentType.contains("image/jpeg"))
                        originalFileExtension = ".jpg";
                    else if(contentType.contains("image/png"))
                        originalFileExtension = ".png";
                    else  // 다른 확장자일 경우 처리 x
                        break;
                }

                // 랜덤 UUID로 새로운 파일이름 생성
                String new_file_name = UUID.randomUUID() + originalFileExtension;

                // 파일엔티티 생성
                File file = File.builder()
                                .fileNo(Long.valueOf(i))
                                .fileName(new_file_name)
                                .originalFileName(multipartFile.getOriginalFilename())
                                .savePath(path + java.io.File.separator + new_file_name)
                                .build();

                // 반환 파일 리스트에 추가
                fileList.add(file);

                // 업로드 한 파일 데이터를 지정한 파일에 저장

                try {
                    multipartFile.transferTo(new java.io.File(absolutePath + path + java.io.File.separator + new_file_name));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 파일 권한 설정(쓰기, 읽기)
                fileWithPath.setWritable(true);
                fileWithPath.setReadable(true);
            }
        }
        return new FileResponseDto(fileList);
    }
}