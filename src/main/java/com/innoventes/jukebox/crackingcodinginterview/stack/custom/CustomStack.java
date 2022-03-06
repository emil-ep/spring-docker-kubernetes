package com.innoventes.jukebox.crackingcodinginterview.stack.custom;

import java.util.EmptyStackException;

public class CustomStack<T> {


    private static class StackNode<T> {

        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T item){
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T pop(){
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }
}
