package com.team.appleplate.global.util.file.repository;

import com.team.appleplate.global.util.file.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
