package com.innoventes.jukebox.service.impl;

import com.innoventes.jukebox.exceptions.JukeBoxInternalServerException;
import com.innoventes.jukebox.models.entity.FileStore;
import com.innoventes.jukebox.repository.FileStoreRepository;
import com.innoventes.jukebox.service.StorageService;
import com.innoventes.jukebox.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private FileStoreRepository storageRepository;

    @Value("${jukebox.file.upload.path:/uploads/}")
    private String uploadPath;

    private Path root;

    @Override
    public void init() {
        root = Paths.get(uploadPath);
        try {
            if (!Files.exists(root))
                Files.createDirectory(root);
        } catch (IOException ex) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public FileStore store(MultipartFile file) {
        String fileName = FileUtil.generateProfilePictureName(file);
        try {
            Files.copy(file.getInputStream(), this.root.resolve(fileName));
            FileStore fileStore = new FileStore(fileName, file.getContentType());
            return storageRepository.save(fileStore);
        }catch (IOException ex){
            throw new JukeBoxInternalServerException("Unable to upload file, please try another file");
        }
    }

    @Override
    public FileStore getFile(String id) {
        return null;
    }
}
