package com.innoventes.jukebox.service;

import com.innoventes.jukebox.models.entity.FileStore;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@Service
public interface StorageService {

    void init();

    FileStore store(MultipartFile file);

    FileStore getFile(String id);

    Resource loadFileAsResource(String fileName) throws FileNotFoundException;

    String getDownloadUrl(FileStore store);
}
