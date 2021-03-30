package com.innoventes.jukebox.test.comparator;

import java.util.Comparator;

public class CompareById implements Comparator<Group> {



    @Override
    public int compare(Group o1, Group o2) {
        return o2.getId() - o1.getId();
    }
}
