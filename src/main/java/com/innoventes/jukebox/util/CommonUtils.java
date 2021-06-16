package com.innoventes.jukebox.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

    public static String convertToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            LOGGER.error("Exception while converting the object to json. Object: {}", object, ex);
            return null;
        }
    }

    public static String getJwtTokenFromAuthHeader(String authHeader){
        String[] tokenSplit = authHeader.split("Bearer");
        return tokenSplit[1];
    }
}
