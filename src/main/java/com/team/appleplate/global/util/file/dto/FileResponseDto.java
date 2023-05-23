package com.team.appleplate.global.util.file.dto;

import com.team.appleplate.global.util.file.File;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class FileResponseDto {

    private final List<File> fileList;

    public FileResponseDto(List<File> fileList){
        this.fileList = fileList;
    }
}
