package Leet.Year2026.March;

import java.util.*;

/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
(i.e., there is a directed edge from node i to node graph[i][j])

Example 1:
Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Example 2:
Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

Constraints:
n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.
 */
public class AllPathFromSrc_Target {

    public static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,3));

//        graph[3].add(new Edge(3,3));
    }

    public static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        q.add(0);

        while (!q.isEmpty()){
            int curr = q.remove();

            if (!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(ArrayList<Edge>[] graph){
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0));

        int goal = graph.length-1;

        while (!queue.isEmpty()){
            List<Integer> path = queue.poll();
            int lastNode = path.getLast();

            if (lastNode == goal){
                result.add(new ArrayList<>(path));
            }else {
                ArrayList<Edge> neighbours = graph[lastNode];
                for (Edge neighbour : neighbours){
                    List<Integer> list = new ArrayList<>(path);
                    list.add(neighbour.dest);
                    queue.add(list);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int V = 4;
        /*
            0------->1
            |        |
            |        |
            v        v
            2------->3
         */

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bfs(graph,V);
        System.out.println();

        System.out.println(allPathsSourceTarget(graph));
    }
}
