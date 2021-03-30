package com.innoventes.jukebox.test.linkedlist;

public class LinkedList {

    private Node head;

    public static LinkedList insert(LinkedList list, int data){
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

    public static void printList(LinkedList list){
        Node currentNode = list.head;
        System.out.println("LinkedList: ");
        while (currentNode != null){
            System.out.println(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
    }
}
