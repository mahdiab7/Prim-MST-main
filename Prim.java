// this is the class that implements Prim's algorithm

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Prim {

    private ArrayList<Node> msTree;   // list of nodes that form min-span-tree
    private int mstCost;              // total weight of MST

    public Prim() {
        this.msTree = new ArrayList<>();
        mstCost = 0;
    }

    public ArrayList<Node> getmsTree() {
        return this.msTree;
    }

    public int getmstCost() {
        return this.mstCost;
    }

    public void solveMST(Graph g, String root) {

        // Insert the code that implements Prim's algorithm here.
        // You must find min-span-tree of graph g and store it in property 'msTree'
        // of this class. Also find the total weight of MST and
        // store it in property 'mstCost' of this class

        Node rootNode = null;
        for (Node vertex : g.getVertices()) {
            vertex.setKey(Integer.MAX_VALUE);
            vertex.setParent(null);

            if (vertex.getLabel().contains(root)) {
                rootNode = vertex;
            }
        }

        assert rootNode != null;
        rootNode.setKey(0);

        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();

        for (Node vertex : g.getVertices()) {
            nodePriorityQueue.add(vertex);
        }

        while (!nodePriorityQueue.isEmpty()) {
            Node u = nodePriorityQueue.peek();
            LinkedList<Edge> uEdges = u.getEdges();
            for (Edge e : uEdges) {
                Node v = e.getDestination();
                int u_vWeight = e.getWeight();
                if (nodePriorityQueue.contains(e.getDestination()) && u_vWeight < v.getKey()) {
                    nodePriorityQueue.remove(v);
                    v.setParent(u);
                    v.setKey(u_vWeight);
                    nodePriorityQueue.add(v);
                }
            }
            getmsTree().add(u);
            this.mstCost = getmstCost() + u.getKey();
            nodePriorityQueue.remove(u);
        }
    }

    public void printMST() {               //print min-span-tree and the total cost
        for (Node v : this.msTree) {
            if (v.getParent() == null)
                System.out.println("Root " + v.getLabel());
            else
                System.out.println("Edge " + v.getParent().getLabel() + " -- " + v.getLabel() +
                        " Weight= " + v.getKey());
        }
        System.out.println("Total MST cost: " + this.mstCost);
    }
}
