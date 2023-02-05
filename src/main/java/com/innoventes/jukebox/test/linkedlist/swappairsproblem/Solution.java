package com.innoventes.jukebox.test.linkedlist.swappairsproblem;

public class Solution {

    public static void main(String[] args) {
        ListNode fourth = new ListNode(4, null);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);
        ListNode head = new ListNode(0, first);

        ListNode swapped = swapPairs(head);
        System.out.println(swapped);
    }

    public static ListNode swapPairs(ListNode head){
//        if (head == null || head.next == null) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;

        while(current.next != null && current.next.next != null){
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;
            current = current.next.next;
        }
        return temp.next;

    }
}
