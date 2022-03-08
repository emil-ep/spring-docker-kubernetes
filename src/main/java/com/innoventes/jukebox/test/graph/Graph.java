package com.innoventes.jukebox.test.graph;

public class Graph {

    private Node[] nodes;
    private Node root;

    public Graph(Node[] nodes, Node root) {
        this.root = root;
        this.nodes = nodes;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
