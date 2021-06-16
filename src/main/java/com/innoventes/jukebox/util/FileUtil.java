package com.innoventes.jukebox.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;

public class FileUtil {


    public static String generateProfilePictureName(MultipartFile file) {
        Calendar calendar = Calendar.getInstance();
        Long timeInMillis = calendar.getTimeInMillis();
        return timeInMillis  + "_pp_" + file.getOriginalFilename();
    }
}
