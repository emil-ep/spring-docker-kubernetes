package com.innoventes.jukebox.test.string;

public class StringPermuationCheck {


    public static void main(String[] args) {
        String s = "abc";
        String s1 = "cba";

        char[] sChars = s.toCharArray();
        if (s.length() != s1.length()){
            System.out.println("Not a permutation");
        }
        for (char w : sChars){
            if (s1.contains(String.valueOf(w)))
                continue;
            else {
                System.out.println("Not a permutation");
                break;
            }
        }
    }
}
