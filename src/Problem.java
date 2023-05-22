import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem {

    public Problem() {

    }

    // o valor de graph[x*2][y*2] é o
    public int solve(int[][] originalGgraph, int numNodes) {
        for (int i = 0; i < numNodes; i++) {
            List<Edge> edges = graph[i];
            for (Edge e : edges) {

            }
            graph[i].contains()
        }
    }

    private int[][] buildNetwork(List<Integer>[] edges, int[] populations, int[] departureCapacities, int safe) {
        int[][] network = new int[edges.length*2][edges.length*2];
        for (int i = 0; i < edges.length; i++) {
            List<Integer> edgesList = edges[i];
            network[0][i] = populations[i];
            network[i][i+edges.length] = departureCapacities[i];
            for (int j : edgesList) {
                network[i+edges.length][j] = Integer.MAX_VALUE;
            }
        }
        return network;
    }

    private int edmondsKarp(List<Edge>[] edges, int numNodes, int source, int sink) {
        int[][] network = buildNetwork(edges, sink);
        int[][] flow = new int[numNodes][numNodes];
        for (Edge e : edges) {
            flow[e.getX()][e.getY()] = 0;
        }
        int[] via = new int[numNodes];
        int flowValue = 0;
        int increment;


        while ( ( increment = findPath(edges, numNodes, flow, source, sink, via) ) != 0 ) {
            flowValue += increment;
            // Update flow.
            int node = sink;
            while ( node != source ) {
                int origin = via[node];
                flow[origin][node] += increment;
                flow[node][origin] -= increment;
                node = origin;
            }
        }
    return flowValue;
}

    private int findPath(List<Edge> edges, int numNodes, int[][] flow, int source, int sink, int[] via) {
            Queue<Integer> waiting = new LinkedList<>();
            boolean[] found = new boolean[numNodes];
            for every Node v in network.nodes()
            found[v] = false;
            L[] pathIncr = new L[numNodes];
            waiting.enqueue(source);
            found[source] = true;
            via[source] = source;
            pathIncr[source] = ;
    }
}

