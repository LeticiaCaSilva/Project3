import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem {

    private List<Pair> edges;
    private int numNodes;
    private int[] populations;
    private int[] departureCapacities;
    private int safe;

    public Problem(List<Pair> edges, int numNodes, int[] populations, int[] departureCapacities, int safe) {
        this.edges = edges;
        this.numNodes = numNodes;
        this.populations = populations;
        this.departureCapacities = departureCapacities;
        this.safe = safe;
    }

    // o valor de graph[x*2][y*2] é o
    public int solve() {
        List<Edge>[] finalGraph = buildNetwork();
        return edmondsKarp(finalGraph, numNodes, 0, safe);
    }



    private List<Edge>[] buildNetwork() {
        List<Edge>[] finalGraph = new List[(numNodes*2)+1];
        finalGraph[0] = new LinkedList<>();
        for (int i = 1; i < numNodes; i++) {
            if (i == safe){
                finalGraph[i] = new LinkedList<>();
                continue;
            }
            if (finalGraph[i+numNodes] == null)
                finalGraph[i+numNodes] = new LinkedList<>();
            if (finalGraph[i] == null)
                finalGraph[i] = new LinkedList<>();
            finalGraph[0].add(new Edge(i, populations[i]));
            finalGraph[i].add(new Edge(i+numNodes, departureCapacities[i]));
        }

        for (int i = 0; i < edges.size(); i++) {
            Pair p = edges.get(0);
            System.out.println(p.getY());
            finalGraph[p.getX()+numNodes].add(new Edge(p.getY(), Integer.MAX_VALUE));
            finalGraph[p.getY()].add(new Edge(p.getX()+numNodes, 0));
        }
        return finalGraph;
    }

    private int edmondsKarp(List<Edge>[] network, int numNodes, int source, int sink) {
        int[][] flow = new int[numNodes][numNodes];
        int[] via = new int[numNodes];
        int flowValue = 0;
        int increment;
        while ( ( increment = findPath(network, numNodes, flow, source, sink, via) ) != 0 ) {
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

    private int findPath(List<Edge>[] network, int numNodes, int[][] flow, int source, int sink, int[] via) {
            Queue<Integer> waiting = new LinkedList<>();
            boolean[] found = new boolean[numNodes];
            for (int i = 0; i < numNodes; i++) {
                found[i] = false;
            }
            int[] pathIncr = new int[numNodes];
            waiting.add(source);
            found[source] = true;
            via[source] = source;
            pathIncr[source] = Integer.MAX_VALUE;

            do {
                int origin = waiting.remove();
                for (int i = 0; i < network.length; i++) {
                    for (Edge e : network[i]) {
                        int destin = e.getDestination();
                        int residue = e.getCost() - flow[i][e.getDestination()];
                        if (!found[destin] && residue > 0) {
                            via[destin] = origin;
                            pathIncr[destin] = Math.min(pathIncr[origin], residue);
                            if (destin == sink)
                                return pathIncr[destin];
                            waiting.add(destin);
                            found[destin] = true;
                        }
                    }
                }
            } while ( !waiting.isEmpty() );
            return 0;
    }
}

