package com.innoventes.jukebox.test.linkedlistexample;

public class LinkedList {

    private Node head;

    public static LinkedList insert(int data, LinkedList list){
        Node newNode = new Node(data);
        newNode.setNext(null);

        if (list.head == null){
            list.head = newNode;
        }else{
            Node last = list.head;
            while (last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(newNode);
        }
        return list;
    }


}
