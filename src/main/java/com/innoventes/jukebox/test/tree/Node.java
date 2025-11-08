package com.innoventes.jukebox.test.tree;

public class Node {

    private Node left;
    private Node right;
    private int value;

    public Node(Node left, Node right, int value){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
