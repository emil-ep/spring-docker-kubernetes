package com.innoventes.jukebox.test.palindrome;

public class Solution {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int number = x;
        int reverseNumber = 0;
        while(x > reverseNumber){
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        if(number == reverseNumber){
            return true;
        }else{
            return false;
        }

    }


}
