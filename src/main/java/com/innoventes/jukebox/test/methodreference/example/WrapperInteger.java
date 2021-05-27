package com.innoventes.jukebox.test.methodreference.example;

public class WrapperInteger {

    private Integer value;

    private String id;

    public WrapperInteger(Integer integer){
        this.value = integer;
        this.id = Double.toString(Math.random());
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
