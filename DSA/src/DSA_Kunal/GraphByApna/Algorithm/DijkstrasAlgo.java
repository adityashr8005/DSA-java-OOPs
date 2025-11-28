package DSA_Kunal.GraphByApna.Algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

    public static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    //Pair class to compare the shortest distance for priorityQueue.
    public static class pair implements Comparable<pair>{
        int node;
        int dist;

        pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        //Java does not know by default how to compare two pair objects, so we must define our own comparing rule.
        @Override
        public int compareTo(pair p2){ //compareTo method to compare in basis of dist
           return this.dist - p2.dist; //ascending order  ||  (p2.dist - this.dist) -> descending order
            /*
            Case 1: return positive value (> 0)
                means: this is greater than p2
            Case 2: return negative value (< 0)
                means: this is smaller than p2
            Case 3: return 0
                means: both are equal
             */
        }
    }

    //Dijkstra's Algorithm Method
    public static void dijkstras(ArrayList<Edge>[] graph, int src, int V){
        //Using priorityQueue instead of Queue
        //It sort the data as priority (default -> small==more priority)
        /*
        A PriorityQueue does NOT store elements in sorted order like an array/list.
        Instead:
            It stores elements in a binary heap
            It always keeps the minimum element at the top (for min-heap behavior)
         */
        PriorityQueue<pair> pq = new PriorityQueue<>();

        //Initializing visited[] and distance[] array.
        boolean[] vis = new boolean[V];
        int[] dist = new int[V];

        //Initialized every node distance with max(infinity) except source(src=0)
        for (int i=0; i<V; i++){
            if (i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //Initialize with adding pair for src( 0(node) , 0(dist) )
        pq.add(new pair(0,0));

        //Running until pq become empty
        while (!pq.isEmpty()){
            pair curr = pq.remove(); //remove the first pair

            //Run only if the node is not visited
            if (!vis[curr.node]){
                vis[curr.node] = true;

                for (int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i); //Fetching neighbor's (src,dest,wt)

                    int u = e.src;
                    int v = e.dest;
                    ///Relaxation
                    if (dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new pair(v,dist[v])); //Adding its new neighbor node pair. Add in ascending order comparing dist.
                    }
                }
            }
        }

        //Printing all the shortest distance outcomes from source which are stored in forms of array
        for (int num : dist) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        dijkstras(graph,0,V);
    }
}
