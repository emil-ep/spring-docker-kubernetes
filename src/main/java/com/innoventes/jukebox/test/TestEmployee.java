package com.innoventes.jukebox.test;

import java.util.Objects;

public class TestEmployee {


    private String name;

    private int id;

    public TestEmployee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEmployee that = (TestEmployee) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int prime = 33;
        return prime * this.id;
    }
}
