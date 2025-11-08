package com.innoventes.jukebox.crackingcodinginterview.queue.queuewith2stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyQueue<T> {

    private Stack<T> inStack;
    private Stack<T> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(T item){
        this.inStack.push(item);
    }


    public T pop(){
        if (outStack.size() == 0 && inStack.size() == 0){
            throw new EmptyStackException();
        }
        if (outStack.size() != 0){
            return outStack.pop();
        }
        int size = inStack.size();
        for (int i = 0; i < size; i++){
            T item = inStack.pop();
            outStack.push(item);
        }
        return outStack.pop();
    }

    public boolean empty(){
        if (outStack.size() == 0 && inStack.size() == 0){
            return true;
        }
        return false;
    }

    public T peek(){
        if (outStack.size() == 0 && inStack.size() == 0){
            throw new EmptyStackException();
        }
        if (outStack.size() != 0){
            return outStack.peek();
        }
        int size = inStack.size();
        for (int i = 0; i < size; i++){
            T item = inStack.pop();
            outStack.push(item);
        }
        return outStack.peek();
    }


}
