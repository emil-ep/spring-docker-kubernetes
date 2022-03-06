package com.innoventes.jukebox.crackingcodinginterview.queue.queuewith2stack;

public class QueueExecutor {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        System.out.println(myQueue.peek());

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        myQueue.push(5);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}
