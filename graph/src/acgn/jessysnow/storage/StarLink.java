package acgn.jessysnow.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 链式向前星
 * StarLink 太酷了
 */
public class StarLink {

    private final List<Edge> edges;
    private final int[] heads;

    public StarLink() {
        this.edges = new ArrayList<>();
        this.heads = new int[1024];
        Arrays.fill(heads, -1);
    }

    public void addEdge(int from, int to) {
        Edge newEdge = new Edge(to);
        newEdge.next = heads[from];
        heads[from] = edges.size();
        edges.add(newEdge);
    }

    public boolean findEdge(int from, int to) {
        if (-1 == heads[from]) {
            return false;
        }

        Edge edge = edges.get(heads[from]);
        while (edge.next != -1) {
            if (edge.to == to) {
                break;
            }

            edge = edges.get(edge.next);
        }

        return edge.to == to;
    }

    private static class Edge {
        public int to;
        public int next;

        public Edge(int to) {
            this.to = to;
        }
    }

    public static void main(String[] args) {
        StarLink starLink = new StarLink();
        starLink.addEdge(1, 2);
        starLink.addEdge(2, 3);
        starLink.addEdge(3, 4);
        starLink.addEdge(3, 5);
        starLink.addEdge(4, 6);
        starLink.addEdge(5, 6);

        System.out.println(starLink.findEdge(1, 2));
        System.out.println(starLink.findEdge(1, 3));
        System.out.println(starLink.findEdge(3, 5));
        System.out.println(starLink.findEdge(4, 5));
    }
}
