package com.wisilica.ignite.tree;

public class Main {


    private  static int sumOfEvenLevel = 0;
    private static  int sumOfOddLevel = 0;

    public static void main(String[] args) {

        Node forthNode = new Node(null, null, 4);
        Node fifthNode = new Node(null, null, 5);
        Node sxthNode = new Node(null, null, 6);
        Node sevenNode = new Node(null, null, 7);
        Node secondNode = new Node(forthNode, fifthNode, 10);
        Node thirdNode = new Node(sxthNode, sevenNode, 20);
        Node rootNode = new Node(secondNode, thirdNode, 1);
        System.out.println(getDifference(rootNode));
    }

    public static int getDifference(Node n){

        int levelCounter = 0;
        int diff = traverse(n, levelCounter);
        return diff;
    }

    public static int traverse(Node n, int levelCounter){

        if (levelCounter  % 2 == 0){
            sumOfEvenLevel = sumOfEvenLevel + n.getValue();
            levelCounter = levelCounter + 1;
        }else{
            sumOfOddLevel  = sumOfOddLevel + n.getValue();
            levelCounter = levelCounter + 1;
        }

        if(n.getLeft() != null){
            traverse(n.getLeft(), levelCounter);
        }
        if(n.getRight() != null){
            traverse(n.getRight(), levelCounter);
        }
        int difference = sumOfEvenLevel - sumOfOddLevel;
        return difference;
    }


}
