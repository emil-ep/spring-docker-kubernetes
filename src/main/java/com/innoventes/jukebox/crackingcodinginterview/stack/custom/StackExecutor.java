package com.innoventes.jukebox.crackingcodinginterview.stack.custom;

public class StackExecutor {

     public static void main(String[] args) {
          CustomStack<Integer> customStack = new CustomStack<>();
          customStack.push(1);
          customStack.push(2);
          customStack.push(3);



          System.out.println(customStack.pop());
          System.out.println(customStack.pop());
          System.out.println(customStack.pop());
     }
}
