package acgn.jessysnow.storage;

import java.util.*;

/**
 * 邻接矩阵实现
 */
public class AdjMatrix {

    /**
     * 查找边，O(1)
     */
    private static boolean findEdge(Integer[][] adjMatrix, int from, int to) {
        return adjMatrix[from][to] == 1;
    }

    /**
     * 深搜，O(n^2)
     *  O(n) 内层遍历
     *  O(n) 外层递归
     */
    private static List<Integer> dfs(Integer[][] adjMatrix, int from, Set<Integer> visited) {
        if (visited.contains(from)) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < adjMatrix[from].length; ++i) {
            if (1 == adjMatrix[from][i]) {
                res.add(from);
                res.add(i);
                res.addAll(dfs(adjMatrix, i, visited));
            }
        }

        return res;
    }

    private static List<Integer> bfs(Integer[][] adjMatrix, int from) {
        Set<Integer> visted = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(from);

        while (!queue.isEmpty()) {
            Integer tempFrom = queue.poll();
            if (visted.contains(tempFrom)) {
                continue;
            }

            visted.add(tempFrom);
            Integer[] tos = adjMatrix[tempFrom];
            for (int i = 0; i < tos.length; ++ i) {
                if (1 == tos[i]) {
                    res.add(i);
                    queue.offer(i);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Integer[][] adjMatrix=  new Integer[5][5];
        Arrays.fill(adjMatrix[0], 0);
        Arrays.fill(adjMatrix[1], 0);
        Arrays.fill(adjMatrix[2], 0);
        Arrays.fill(adjMatrix[3], 0);
        Arrays.fill(adjMatrix[4], 0);

        adjMatrix[0][1] = 1;
        adjMatrix[1][2] = 1;
        adjMatrix[2][3] = 1;
        adjMatrix[2][4] = 1;
        adjMatrix[3][4] = 1;

        System.out.println(findEdge(adjMatrix, 2, 3));
        System.out.println(dfs(adjMatrix, 1, new HashSet<>()));
        System.out.println(bfs(adjMatrix, 1));
    }
}
