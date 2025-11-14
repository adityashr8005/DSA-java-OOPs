package DSA_Kunal.GraphByApna.CycleDetection;

import java.util.ArrayList;

public class DirectedGraph {

    public static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    //Method for creating graph.
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
    }

    //Method to check if directedGraph is cycle or not.
    public static boolean isCycleDirected(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] rec){
        vis[curr] = true; //Confirmation of visited
        rec[curr] = true; //Adding to stack

        //Loop to check all node neighbour
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i); // Eg: curr-0 (e -> 0->{0,2})

            if (rec[e.dest]){//Condition to check if next neighbor already exist in recursionStack.
                return true;
            }
            else if (!vis[e.dest]) { //if not visited yet, then dfs call with updated neighbor.
                if(isCycleDirected(graph,e.dest,vis,rec)){
                    return true;
                }
            }
        }
        //Update back to false <-> removing from stack
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        //Creating arrayList type graph.
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        boolean[] recStack = new boolean[V];
        //Loop to check all disconnected graph - if exist
        for (int i=0; i<V; i++){
            if (!vis[i]){
                boolean isCycle = isCycleDirected(graph,0,vis,recStack);
                if (isCycle){ //If atLeast one cycle is found break.
                    System.out.println(isCycle);
                    break;
                }
            }
        }
    }
}
