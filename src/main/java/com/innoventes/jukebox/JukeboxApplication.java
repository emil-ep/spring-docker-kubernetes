package com.innoventes.jukebox;

import com.innoventes.jukebox.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JukeboxApplication {

	@Autowired
	private StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(JukeboxApplication.class, args);
	}

	@PostConstruct
	public void initUploadFolder(){
		storageService.init();
	}

}
