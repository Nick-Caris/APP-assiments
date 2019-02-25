package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import graphs.Graph.Edge;
import graphs.Graph.Vertex;

public class WeightedShortestPath {

    public static void main(String[] args) {
        Graph g = new Graph();
        // Vertexes
        Vertex v1 = g.new Vertex("v1");
        Vertex v2 = g.new Vertex("v2");
        Vertex v3 = g.new Vertex("v3");
        // Edges
        v1.addEdge(g.new Edge(v2, 1));
        v2.addEdge(g.new Edge(v3, 1));
        // Graph
        g.vertexes.addAll(Arrays.asList(v1, v2, v3));
        new WeightedShortestPath(g).weighted("v1");
    }

    Graph g;

    public WeightedShortestPath(Graph g) {
        this.g = g;
    }

    public void weighted(String startName) {
        //
        Vertex start = this.g.getVertex(startName);
        Queue<Vertex> q = new LinkedList<>();
        q.add(start);
        start.dist = 0;
        while (!q.isEmpty()) {
            Vertex v = q.remove();
            for (Edge e : v.edges) {
                Vertex dest = e.dest;
                double newDist = v.dist + e.cost;
                if (dest.prev == null || dest.dist > newDist) {
                    dest.dist = newDist;
                    dest.prev = v;
                    q.add(dest);
                }
            }
        }
    }
}
