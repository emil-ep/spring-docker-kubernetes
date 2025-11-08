package com.innoventes.jukebox.test.graph;

import java.util.Arrays;

public class DepthFirstSearch {

    public static void main(String[] args) {

        Node node0 = new Node("0");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");


        Node[] node0Children = new Node[]{node1, node4, node5};
        Node[] node1Children = new Node[]{node4, node3};
        Node[] node2Children = new Node[]{node1};
        Node[] node3Children = new Node[]{node2, node4};

        node0.setChildren(node0Children);
        node1.setChildren(node1Children);
        node2.setChildren(node2Children);
        node3.setChildren(node3Children);

        Node[] nodes = new Node[]{node0, node1, node2, node3, node4, node5};

        Graph graph = new Graph(nodes, node0);
        traverse(graph.getRoot());

    }

    private static void traverse(Node root) {

        if (root == null) return;
        System.out.println(root.getName());
        root.setVisited(true);
        if (root.getChildren() != null)
            Arrays.stream(root.getChildren()).forEach(n -> {
                if (!n.isVisited())
                    traverse(n);
            });
    }
}
