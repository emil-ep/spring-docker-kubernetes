package com.innoventes.jukebox.test.linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.insert(linkedList,1);
        LinkedList.insert(linkedList,2);
        LinkedList.insert(linkedList,3);
        LinkedList.insert(linkedList,4);
        LinkedList.insert(linkedList,5);
        LinkedList.insert(linkedList,6);
        LinkedList.insert(linkedList,7);
        linkedList = LinkedList.insert(linkedList,8);

        LinkedList.printList(linkedList);

    }
}
