package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.FileStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStoreRepository extends JpaRepository<FileStore, String> {
}
