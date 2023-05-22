package com.innoventes.jukebox.test.leetcode.lengthoflastword;

public class Main {

    public static void main(String[] args) {

        String s = "";
        System.out.println(findLengthOfLastWord(s));
    }

    private static int findLengthOfLastWord(String sentence){

        String[] splitWords = sentence.split(" ");
        if (splitWords.length > 0){
            String lastWord = splitWords[splitWords.length - 1];
            char[] lastWordChars = lastWord.toCharArray();
            return lastWordChars.length;
        }else{
            System.out.println("Word is not present");
            return 0;
        }

    }
}
