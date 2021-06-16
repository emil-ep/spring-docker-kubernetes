package com.innoventes.jukebox.service.impl;

import com.innoventes.jukebox.exceptions.JukeBoxInternalServerException;
import com.innoventes.jukebox.models.entity.FileStore;
import com.innoventes.jukebox.repository.FileStoreRepository;
import com.innoventes.jukebox.service.StorageService;
import com.innoventes.jukebox.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.innoventes.jukebox.constants.ApiConstants.*;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private FileStoreRepository storageRepository;

    @Value("${jukebox.file.upload.path:/uploads/}")
    private String uploadPath;

    private Path root;

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Override
    public void init() {
        root = Paths.get(uploadPath);
        try {
            if (!Files.exists(root))
                Files.createDirectory(root);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
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

    @Override
    public Resource loadFileAsResource(String fileName) throws FileNotFoundException {
        try{
            Path filePath = this.root.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) return resource;
            else throw new FileNotFoundException("File not found " + fileName);
        }catch (MalformedURLException ex){
            LOGGER.error(ex.getMessage());
            throw new FileNotFoundException("File not found " + fileName);
        }
    }

    @Override
    public String getDownloadUrl(FileStore store) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(BASE_URL + DOWNLOAD_FILE_BASE_PATH)
                .path(store.getName())
                .toUriString();
    }
}
