package acgn.jessysnow.storage;

import java.util.*;

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

    /**
     * 查找边，O(n)
     * 如果一个点和图内其他所有的点均直接连接，最差情况下需要遍历从该点出发的所有的边
     */
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

    /**
     * 深搜
     */
    public List<Edge> dfs(int from, Set<Integer> visited) {
        if (visited.contains(from)) {
            return Collections.emptyList();
        }

        ArrayList<Edge> res = new ArrayList<>();

        while (from != -1 && heads[from] != -1) {
            visited.add(from);
            Edge edge = edges.get(heads[from]);
            res.add(edge);
            res.addAll(dfs(edge.next, visited));
            from = edge.to;
        }

        return res;
    }

    public void allEdges() {
        for (int from = 0; from < heads.length; ++ from) {
            if (heads[from] == -1) {
                continue;
            }
            System.out.printf("from:%d\n", from);
            int edgeIndex = heads[from];
            while (edgeIndex != -1) {
                Edge edge = edges.get(edgeIndex);
                System.out.printf("\tto:%d\n", edge.to);
                edgeIndex = edge.next;
            }
        }
    }

    public static class Edge {
        public int to;
        public int next;

        public Edge(int to) {
            this.to = to;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", next=" + next +
                    '}';
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
        starLink.allEdges();
    }
}
