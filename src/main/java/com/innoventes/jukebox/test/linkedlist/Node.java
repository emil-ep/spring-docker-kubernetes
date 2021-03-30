package com.innoventes.jukebox.test.linkedlist;

public class Node {

    private int data;
    private Node next;

    public Node(int d){
        this.data = d;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
