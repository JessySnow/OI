package acgn.jessysnow.storage;

import java.util.*;

/**
 * 邻接表实现
 */
public class AdjList {

    /**
     * 查找边是否存在, O(n)
     *  O(n) 在一个点和其他所有的点都存在关联时需要遍历 n 次
     */
    private static boolean findEdge(List<List<Integer>> adjList, int from, int to) {
        if (null == adjList.get(from)) {
            return false;
        }

        for (Integer i : adjList.get(from)) {
            if (to == i) {
                return true;
            }
        }

        return false;
    }


    /**
     * 优化后的查找边是否存在，需要邻接表对出边进行排序, O(logn)
     *  二分搜索可以从 O(n) 优化至 O(logn)
     */
    private static boolean findEdgeOptimized(List<List<Integer>> adjList, int from, int to) {
        List<Integer> fromTo = adjList.get(from);
        if (null == fromTo) {
            return false;
        }

        int left = 0, right = fromTo.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (fromTo.get(mid) == to) {
                return true;
            } else if (fromTo.get(mid) > to) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    /**
     * 深搜, O(n + m) AKA O(n) + O(m)
     *  O(n) 遍历所有的点的时间复杂度
     *  O(m) 遍历所有的边的时间复杂度
     */
    private static List<Integer> dfs(List<List<Integer>> adjList, int from, Set<Integer> visited) {
        if (visited.contains(from) || null == adjList.get(from)) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        for (Integer to : adjList.get(from)) {
            res.add(from);
            res.add(to);
            visited.add(from);
            res.addAll(dfs(adjList, to, visited));
        }

        return res;
    }

    /**
     * 广搜，O(n + m)
     */
    private static List<Integer> bfs(List<List<Integer>> adjList, int from) {
        Set<Integer> visited = new HashSet<>();

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(from);
        while (!queue.isEmpty()) {
            int tempFrom = queue.poll();
            if (visited.contains(tempFrom)) {
                continue;
            }
            res.add(tempFrom);
            visited.add(tempFrom);
            for (Integer to : adjList.get(tempFrom)) {
                queue.offer(to);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        ArrayList<Integer> fromZero = new ArrayList<>();
        fromZero.add(1);
        ArrayList<Integer> fromOne = new ArrayList<>();
        fromOne.add(2);
        ArrayList<Integer> fromTwo = new ArrayList<>();
        fromTwo.add(3);
        fromTwo.add(4);
        ArrayList<Integer> fromThree = new ArrayList<>();
        fromThree.add(4);
        ArrayList<Integer> fromFour = new ArrayList<>();

        adjList.add(fromZero);
        adjList.add(fromOne);
        adjList.add(fromTwo);
        adjList.add(fromThree);
        adjList.add(fromFour);

        System.out.println(findEdge(adjList, 1, 2));
        System.out.println(findEdgeOptimized(adjList, 1, 2));

        System.out.println(dfs(adjList, 0, new HashSet<>()));
        System.out.println(bfs(adjList, 0));
    }
}
