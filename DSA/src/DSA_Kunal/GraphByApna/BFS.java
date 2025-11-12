package DSA_Kunal.GraphByApna;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    //Method that create graph...
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
    }

    //Method for BFS traversal.
    public static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];

        q.add(0);

        while (!q.isEmpty()){
            int curr = q.remove();

            if (!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //Method for disConnected Component Graph (BFS Traversal)
    public static void disConnectedGraph(ArrayList<Edge>[] graph, boolean[] vis, int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()){
            int curr = q.remove();

            if (!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        /*
           1-----3
          /      | \
         0       |  5---6
          \      | /
           2-----4
         */
        //Initializing graph[] of arrayList..
        ArrayList<Edge> graph[] = new ArrayList[V];

        //Method call for creating graph.
        createGraph(graph);

        //Method call for BFS traversal.
        bfs(graph,V);   // 0 1 2 3 4 5 6
        System.out.println();

        //For disConnected Component graph
        boolean[] vis = new boolean[V];
        for (int i=0; i<V; i++){
            disConnectedGraph(graph,vis,i);
        }
    }

}
