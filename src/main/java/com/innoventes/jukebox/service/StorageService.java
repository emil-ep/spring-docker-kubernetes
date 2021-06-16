package com.innoventes.jukebox.service;

import com.innoventes.jukebox.models.entity.FileStore;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface StorageService {

    void init();

    FileStore store(MultipartFile file);

    FileStore getFile(String id);
}
