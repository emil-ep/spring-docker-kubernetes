package com.innoventes.jukebox.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TwoSum {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l12.next = l13;
        l11.next = l12;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l22.next = l23;
        l21.next = l22;

        ListNode result = findSum(l11, l21);
        System.out.println(result);
    }

    private static ListNode findSum(ListNode l1, ListNode l2){
        Queue<Integer> l1Queue = new LinkedBlockingQueue<>();
        Queue<Integer> l2Queue = new LinkedBlockingQueue<>();

        while(l1.next != null){
            l1Queue.add(l1.val);
            l1 = l1.next;
        }
        l1Queue.add(l1.val);

        while(l2.next != null){
            l2Queue.add(l2.val);
            l2 = l2.next;
        }
        l2Queue.add(l2.val);

        int maxSize = Math.max(l1Queue.size(), l2Queue.size());

        int carryOver = 0;
        int totalSum = 0;
        for (int i = 0; i < maxSize; i++){
            int l1Number = 0;
            int l2Number = 0;
            if(!l1Queue.isEmpty()){
                l1Number = l1Queue.poll();
            }
            if (!l2Queue.isEmpty()){
                l2Number = l2Queue.poll();
            }
            int sum = l1Number + l2Number + carryOver;
            if (sum > 10){
                carryOver = 1;
                sum =  sum - 10;
            }else if(sum == 10){
                carryOver = 10;
            }else{
                carryOver = 0;
            }
            int dividend = (int) Math.pow(10, i);

            totalSum = totalSum + (sum * (dividend));
            System.out.println(totalSum);
        }
        ListNode finalNode = null;
        int remainder = 0;
        int i = 1;
        boolean continueLoop = true;
        while (totalSum / 10 != 0){
            remainder = totalSum % 10;
            totalSum = totalSum / 10;
            finalNode = new ListNode(remainder, finalNode);
        }
        remainder = totalSum % 10;
        finalNode = new ListNode(remainder, finalNode);
        return finalNode;
    }
}
