package Leet.November;

/*
Example 1:
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPathGraph {

    //Space complexity is high....DFS
    public static boolean validPath(int n, int[][] edges, int source, int destination){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        //Initialized n*n matrix with 0
        //large memory required as it is converted to n*n
        //Optimal solution convert it to Adjacent List
        for (int i=0; i<n; i++){
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(n, 0));
            list.add(row);
        }

        //Fill value to create adjacency matrix format
        for (int[] edge : edges){
            int u = edge[0]; //edges[0] = {0,1} then, u=0 && v=1
            int v = edge[1]; //edges[1] = {1,2} then, u=1 && v=2

            list.get(u).set(v,1);
            //for undirected graph
            list.get(v).set(u,1);
        }

        boolean[] visited = new boolean[n];
        return dfs(source, destination, list, visited);
    }
    public static boolean dfs(int src, int dest, ArrayList<ArrayList<Integer>> list, boolean[] vis){
        if (src == dest){
            return true;
        }

        vis[src] = true;
        for (int i=0; i<list.size(); i++){
            if (list.get(src).get(i) == 1 && !vis[i]){
                if (dfs(i,dest,list,vis)){
                    return true;
                }
            }
        }
        return false;
    }




    //Optimal solution using BFS -- less space complexity
    public static boolean validPathGraph(int[][] edges, int n, int source, int destination){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        vis[source] = true;

        while (!q.isEmpty()){
            int curr = q.poll();

            if (curr == destination){
                return true;
            }

            for (int i : list.get(curr)){
                if (!vis[i]){
                    vis[i] = true;
                    q.offer(i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0,1},
                {1,2},
                {2,0}
        };
        int source = 0;
        int destination = 2;

        System.out.println(validPath(n, edges, source, destination));
        System.out.println(validPathGraph(edges, n, source, destination));
    }
}
