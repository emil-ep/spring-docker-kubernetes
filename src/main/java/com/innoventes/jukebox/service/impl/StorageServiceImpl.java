package com.innoventes.jukebox.service.impl;

import com.innoventes.jukebox.exceptions.JukeBoxInternalServerException;
import com.innoventes.jukebox.models.entity.FileStore;
import com.innoventes.jukebox.repository.FileStoreRepository;
import com.innoventes.jukebox.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private FileStoreRepository storageRepository;

    @Override
    public FileStore store(MultipartFile file) {
        String fileName = StringUtils.getFilename(file.getOriginalFilename());
        FileStore fileStore;
        try {
            fileStore = new FileStore(fileName, file.getContentType(), file.getBytes());
            return storageRepository.save(fileStore);
        } catch (IOException e) {
            throw new JukeBoxInternalServerException("Unable to uploaded file, please try another file");
        }
    }

    @Override
    public FileStore getFile(String id) {
        return null;
    }
}
