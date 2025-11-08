package com.innoventes.jukebox.test.tree;


//Validate whether a binary tree is balanced or not. Balanced node
// has a difference of 1 between the heights
//right and left subtree
public class ValidateBalancedBinaryTree {

    public static void main(String[] args) {
//  Balanced tree example
//        Node node3 = new Node(3);
//        Node node9 = new Node(9);
//        Node node20 = new Node(20);
//        Node node15 = new Node(15);
//        Node node7 = new Node(7);
//
//        node20.setLeft(node15);
//        node20.setRight(node7);
//        node3.setLeft(node9);
//        node3.setRight(node20);


        // Not balanced tree example
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node3.setLeft(node4);
        node3.setRight(node7);
        node2.setLeft(node3);
        node2.setRight(node6);
        node1.setLeft(node2);
        node1.setRight(node5);

        if (isBalanced(node1)) {
            System.out.println("Tree is balanced");
        } else System.out.println("Tree is not balanced");
    }


    private static boolean isBalanced(Node node) {
        if (node == null) {
            return false;
        }
        int leftSubtreeHeight = findHeight(node.getLeft());
        int rightSubtreeHeight = findHeight(node.getRight());
        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) <= 1) {
            return true;
        } else return false;
    }

    private static int findHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(node.getLeft()), findHeight(node.getRight()));
    }
}
