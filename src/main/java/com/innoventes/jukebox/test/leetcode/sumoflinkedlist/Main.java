package com.innoventes.jukebox.test.leetcode.sumoflinkedlist;

public class Main {

    public static void main(String[] args) {

        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4, node3);
        ListNode node2 = new ListNode(2, node4);


        ListNode node42 = new ListNode(4);
        ListNode node6 = new ListNode(6, node42);
        ListNode node5 = new ListNode(5, node6);

        System.out.println(Solution.addTwoNumbers(node2, node5));
    }
}
