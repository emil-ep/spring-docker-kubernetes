package com.innoventes.jukebox.test.tree;

//Program to validate whether the given binary tree is a binary search tree
public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        Node node10 = new Node(10);
        Node node5 = new Node(5);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        Node node13 = new Node(13);
        Node node12 = new Node(12);
        Node node15 = new Node(15);
        Node node14 = new Node(14);
        Node node16 = new Node(16);

        node8.setLeft(node5);
        node8.setRight(node9);
        node10.setLeft(node8);
        node15.setLeft(node14);
        node15.setRight(node16);
        node13.setLeft(node12);
        node13.setRight(node15);
        node10.setRight(node13);

//        traverse(node10);
//        System.out.println("Valid binary search tree");
        boolean isValid = isValidBST(node10);
        System.out.println(isValid);

    }

   public static boolean isValidBST(Node node){

       return traverse(node, Long.MIN_VALUE, Long.MAX_VALUE);
   }

   public static boolean traverse(Node root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.getValue() <= min || root.getValue() >= max){
            return false;
        }
        return traverse(root.getLeft(), min, root.getValue()) && traverse(root.getRight() ,root.getValue(), max);
   }

}
