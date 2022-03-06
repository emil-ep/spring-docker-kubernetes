package com.innoventes.jukebox.crackingcodinginterview.stack.sort;

import java.util.Scanner;
import java.util.Stack;

//Sort a stack using only another temporary data structure
public class SortStack {


    public static void main(String[] args) {

        Stack<Integer> inputStack = new Stack<>();
        System.out.println("Enter the size of stack :");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.println("Enter the stack elements");
        for (int i = 0; i < size; i++){
            int item = scanner.nextInt();
            inputStack.push(item);
        }
        System.out.println("The sorted stack is as follows");
        printSortedStack(inputStack);
    }

    private static void printSortedStack(Stack<Integer> inputStack){
        Stack<Integer> tempStack = new Stack<>();
        int temp = inputStack.pop();
        tempStack.push(temp);
        while (!inputStack.isEmpty()){
            temp = inputStack.pop();
            while (!tempStack.isEmpty() && temp < tempStack.peek()){
                int tempItem = tempStack.pop();
                inputStack.push(tempItem);
            }
            tempStack.push(temp);
        }
        while (!tempStack.isEmpty()){
            inputStack.push(tempStack.pop());
        }
        while (!inputStack.isEmpty()){
            System.out.println(inputStack.pop());
        }
    }
}
