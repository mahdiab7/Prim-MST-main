// this file contains three classes:
// class Graph
// class Edge
// class Node


import java.util.LinkedList;

public class Graph {
    private int size_V;               // Number of vertices in the graph
    private Node[] vertices;          // Array of vertices (nodes)

    public Graph(int sizeV) {
        this.size_V = sizeV;
        this.vertices = new Node[this.size_V];     // initialize the graph with empty nodes
        for (int i = 0; i < this.size_V; i++) {
            this.vertices[i] = new Node();
        }
    }

    public Node[] getVertices() {
        return this.vertices;
    }

    public void addEdge(String sourceLabel, String destinationLabel, int weight) {

        // insert your code here to add an edge into the graph
        // Note 1: when the run of 'Test_MST_Prim' reaches here,
        //         the graph's node labels are already set in the 'main' method
        // Note 2: since the graph is undirected, for each edge in graph, e.g. a-b,
        //         you have to add one edge for the node labeled 'a' and
        //         another edge for the node labbeled 'b', with the same weight

        Node source = null;
        Node destination = null;

        for (Node n : getVertices()) {
            if (n.getLabel().equals(sourceLabel))
                source = n;
            else if (n.getLabel().equals(destinationLabel))
                destination = n;
        }

        if (source == null || destination == null) {
            System.out.println("Wrong source or destination label!");
            return;
        }

        Edge x, y;
        x = new Edge();
        y = new Edge();

        x.setSource(source);
        x.setDestination(destination);
        x.setWeight(weight);

        y.setSource(destination);
        y.setDestination(source);
        y.setWeight(weight);

        source.getEdges().add(x);
        destination.getEdges().add(y);
    }
}


class Edge {
    private Node source;
    private Node destination;
    private int weight;

    public Node getSource() {
        return this.source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return this.destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    private String label;
    private int key;
    private Node parent;
    private LinkedList<Edge> edges;

    public Node() {
        this.edges = new LinkedList<Edge>();
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public LinkedList<Edge> getEdges() {
        return this.edges;
    }

    @Override
    public int compareTo(Node o) {
        if (this.getKey() > o.getKey()) return 1;
        else if (this.getKey() < o.getKey()) return -1;
        else return 0;
    }
}
