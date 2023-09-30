//A calss containing "main" to Test the implementation of Prim's algorithm

public class Test_MST_Prim {
	 public static void main(String[] args) {

         Graph graph = new Graph(9);
         // set the node labels in the graph
         int pos = 0;
         for (char c: "abcdefghi".toCharArray()) {
        	 graph.getVertices()[pos].setLabel(String.valueOf(c));
        	 pos += 1;
         }
         // insert edges into the graph
         graph.addEdge("a", "b", 4);
         graph.addEdge("a", "h", 8);
         graph.addEdge("b", "h", 11);
         graph.addEdge("b", "c", 8);
         graph.addEdge("h", "i", 7);
         graph.addEdge("i", "g", 6);
         graph.addEdge("c", "f", 4);
         graph.addEdge("c", "d", 7);
         graph.addEdge("d", "e", 9);
         graph.addEdge("d", "f", 14);
         graph.addEdge("e", "f", 10);
         graph.addEdge("h", "g", 1);
         graph.addEdge("c", "i", 2);
         graph.addEdge("g", "f", 2);

         // apply Prim's algorithm to find Min_Span_Tree
         Prim p = new Prim();
         p.solveMST(graph, "a");
         p.printMST();
     }
}


