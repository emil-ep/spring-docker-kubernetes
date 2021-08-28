package com.innoventes.jukebox.test.leetcode.sumoflinkedlist;

import java.util.Stack;

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> l1Stack = new Stack<Integer>();
        Stack<Integer> l2Stack = new Stack<Integer>();

        while(l1.next != null){
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        l1Stack.push(l1.val);

        while(l2.next != null){
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        l2Stack.push(l2.val);

        int[] number1Array = new int[l1Stack.size()];
        int number1Counter = 0;
        while (!l1Stack.isEmpty()){
            number1Array[number1Counter] = l1Stack.pop();
        }

        int[] number2Array = new int[l2Stack.size()];
        int number2Counter = 0;
        while (!l2Stack.isEmpty()){
            number2Array[number2Counter] = l2Stack.pop();
        }

        int sumCounter = number1Counter > number2Counter? number1Counter: number2Counter;



        for (int i = 0; i < number1Array.length; i++){

        }

        String number1 = "";
        while(!l1Stack.isEmpty()){
            number1 += l1Stack.pop();
        }

        String number2 = "";
        while(!l2Stack.isEmpty()){
            number2 += l2Stack.pop();
        }

        Long number1Int = Long.parseLong(number1);
        Long number2Int = Long.parseLong(number2);

        Long sumNumber = number1Int + number2Int;

        String sumStr = String.valueOf(sumNumber);
        int[] numberArray = new int[sumStr.length()];
        for(int i=0; i<sumStr.length(); i++){
            numberArray[i] = Integer.parseInt(sumStr.charAt(i)+"");
        }

        ListNode prev = null;
        for(int i = 0; i < numberArray.length; i++){
            ListNode currentNode = new ListNode(numberArray[i], prev);
            prev = currentNode;
        }

        return prev;

    }
}
