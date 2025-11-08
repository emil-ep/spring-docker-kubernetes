package com.innoventes.jukebox.test.comparator;

import java.util.Comparator;

public class CompareByName implements Comparator<Group> {
    @Override
    public int compare(Group o1, Group o2) {
        return o1.getName().compareTo(o2.getName());
    }


}
