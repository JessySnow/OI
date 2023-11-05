package acgn.jessysnow.storage;

import java.util.*;

/**
 * 直接存边的实现
 */
public class DirectSaveEdge {

    /**
     * 查找边，O(n)
     */
    private static boolean findEdge(List<Edge> edges, int from, int to) {
        for (Edge edge : edges) {
            if (edge.from == from && edge.to == to) {
                return true;
            }
        }

        return false;
    }

    /**
     * 深搜，O(nm)
     *  O(m) 内部 for 循环迭代的复杂度
     *  O(n) 外部递归的复杂度
     */
    private static List<Integer> dfs(List<Edge> edges, int from, Set<Integer> visited) {
        if (visited.contains(from)) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.from == from) {
                res.add(edge.from);
                res.add(edge.to);
                visited.add(edge.from);
                res.addAll(dfs(edges, edge.to, visited));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(4, 5));

        System.out.println(findEdge(edges, 4, 5));
        List<Integer> dfs = dfs(edges, 1, new HashSet<>());
        System.out.println(dfs);
    }

    private static class Edge {
        public int from;
        public int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
