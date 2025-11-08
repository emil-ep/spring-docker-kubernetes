package com.innoventes.jukebox.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    public static boolean isValid(String s) {
        char[] bracketsArray = s.toCharArray();
        if(bracketsArray.length == 1){
            return false;
        }
        if(bracketsArray[0] == ')' || bracketsArray[0] == ']' ||bracketsArray[0] == '}'){
            return false;
        }
        Map<String, String> bracketMap = new HashMap<>();
        bracketMap.put(")", "(");
        bracketMap.put("]", "[");
        bracketMap.put("}", "{");
        Stack<String> bracketStack = new Stack<>();
        for(int i = 0; i < bracketsArray.length; i++){
            if(bracketMap.containsKey(String.valueOf(bracketsArray[i]))){
                if(bracketStack.isEmpty()){
                    return false;
                }
                String previous = bracketStack.pop();
                if(!bracketMap.get(String.valueOf(bracketsArray[i])).equals(previous)){
                    return false;
                }
            }else{
                bracketStack.push(String.valueOf(bracketsArray[i]));
            }
        }
        return bracketStack.size() == 0;
    }
}
