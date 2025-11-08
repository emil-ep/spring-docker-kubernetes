package com.innoventes.jukebox.test.template;

public abstract class Iphone {

    public final String getScreenResolution(){
        return "1160*1160";
    }

    public abstract String getCameraResolution();

    public final String processOrder(){
        String screenResolution = getScreenResolution();
        String cameraResolution = getCameraResolution();
        return "screen resolution: " + screenResolution + " camera Resolution: " + cameraResolution;
    }

}
