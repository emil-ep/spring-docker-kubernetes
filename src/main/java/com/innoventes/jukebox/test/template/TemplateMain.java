package com.innoventes.jukebox.test.template;

public class TemplateMain {

    public static void main(String[] args) {
        IphoneEleven iphoneEleven = new IphoneEleven();
        String result = iphoneEleven.processOrder();
        System.out.println(result);

        Iphone iphone = new IphoneTen();
        iphone.processOrder();
    }
}
