// It is a unweighted graph
// Implement with the help of List<List> meanse Collection of Lists of List
// It containing various function like bfs search , dfs search , etc.
// Most Important data structures in competitive programming.
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
public class unweighted_graph_adjacency_list{
    public static void main(String args[]){
        unweighted_graph graph = new unweighted_graph(5);
        graph.add_undirected(0 , 1);
        graph.add_undirected(0 , 2);
        graph.add_undirected(1 , 3);
        graph.add_undirected(1 , 4);
        // graph.add_undirected(3 , 4);
        System.out.println("This is dfs search using graph");
        System.out.println();
        graph.dfs(0);
        System.out.println(graph.cycle_detection_directed_graph());
        // System.out.println("This is bfs seach using graph");
        // System.out.println();
        // graph.bfs(0);
    }
}
final class unweighted_graph{ // this class is a final class which can't be inherited
    private int nodes; // this is a nodes which represents total node of graph
    private List<List<Integer>> graph; // This is a list of list which is look like < < > , < > , < > ,< > > for three nodes
    private boolean visited[]; // this is boolean array of size n which is used when we do dfs in graph
    unweighted_graph(int nodes){
        this.nodes = nodes;
        visited = new boolean[nodes];
        graph = new ArrayList<>();
        for(int i = 0; i < nodes; i++){
            graph.add(i , new ArrayList<Integer>());
        }
    }
    public void add_directed(int source , int destination){  // this is used to add undirected graph
        graph.get(source).add(destination);
    } 
    public void add_undirected(int source , int destination){ // this is used to add directed graph
        graph.get(source).add(destination); 
        graph.get(destination).add(source);
    }
    public void dfs(int source){ // this is used to bfs traversal in graph
        Stack<Integer> stack = new Stack<Integer>(); // we use stack for dfs
        Arrays.fill(visited , false); 
        // this is used for case like when if we perform bfs first and after try to implement
        //  dfs then visited array is ture already during bfs so for this condition we fill this array false
        stack.push(source);
        visited[source] = true;
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            System.out.println(pop);
            List<Integer> container = graph.get(pop);
            for(Integer child: container){
                if(!visited[child]){
                    stack.push(child);
                    visited[child] = true;
                }
            }
        }
    }
    public void bfs(int source){
        Queue<Integer> queue = new LinkedList<Integer>(); // remember we use queue for bfs
        // this is used for case like when if we perform dfs first and after try to implement
        //  bfs then visited array is ture already during bfs so for this condition we fill this array false
        Arrays.fill(visited, false);
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            Integer pop = queue.poll();
            System.out.println(pop);
            List<Integer> container = graph.get(pop);
            for(Integer child: container){
                if(!visited[child]){
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }

    }
    public boolean cycle_detection_directed_graph(){
        for(int i = 0;i < nodes; i++){ // we check every node because we can't know that all the graphs are connected or dissconnected
            int helper [] = new int[nodes];
            Arrays.fill(helper , -1);
            if(cycle_detection(helper, i)){
                return true;
            }
        }
        return false;
    }
    public boolean cycle_detection(int helper[] , int source){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        helper[source] = 0;
        while(!queue.isEmpty()){
            Integer pop = queue.poll();
            helper[pop] = 1;
            List<Integer> list  = graph.get(pop);
            for(Integer child : list){
                if(helper[child] == 0){
                    return true;
                }
                if(helper[child] == -1){
                    queue.add(child);
                    helper[child] = 0;
                }
            }
        }
        return false;
    }
    
}