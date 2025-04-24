//import org.graphstream.graph.*;
//import org.graphstream.graph.implementations.*;
public class circularGraphStream {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");


        // Vertex names and their offsets
        String[] vertices = {"I", "A", "E", "F", "T", "S"};
        int[] offsets = {2, 5, 4, 2, 2, 3};

        int n = vertices.length;

        // Add nodes (vertices)
        for (String vertex : vertices) {
            //graph.addNode(vertex);
        }

        // Add edges based on offsets
        for (int i = 0; i < n; i++) {
            String from = vertices[i];
            String left = vertices[(i - offsets[i] + n) % n];
            String right = vertices[(i + offsets[i]) % n];

        }
    }
}