package com.innoventes.jukebox.test.needleinhaystack;

public class Main {

    public static void main(String[] args) {

        String haystack = "mississippi";
        String needle = "issipi";
        System.out.println(findStr(haystack, needle));
    }

    private static int findStr(String haystack, String needle){

        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        if (needle.length() == 0){
            return 0;
        }
        if (haystack.length() == 0){
            return -1;
        }
        if (needle.length() > haystack.length()){
            return -1;
        }

        for(int i = 0; i < haystackArr.length; i++){

            for (int j = 0; j < needleArr.length; j++){

                if ((i+j) >= haystackArr.length){
                    return -1;
                }

                if (haystackArr[i + j] != needleArr[j]){
                    break;
                }
                if (j == needleArr.length - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}
