package com.innoventes.jukebox.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * This particular method needs to be overridden to allow cross origin resource sharing (cors),
     * otherwise requests from browser won't be accepted
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //The pattern, allowedOrigins and allowedMethods should be restricted to the frontend application url,
        //so that CORS attacks won't happen
        registry.addMapping("/**").allowedMethods("*");
    }
}
