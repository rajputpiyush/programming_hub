import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class unweighted_graph_adjacency_list{
    public static void main(String args[]){
        unweighted_graph graph = new unweighted_graph(4);
        graph.add_bidirectional(0 , 1);
        graph.add_bidirectional(1 , 2);
        graph.add_bidirectional(2 , 3);
        graph.add_bidirectional(0 , 3);
        graph.dfs(0);
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
    public void add_undirectional(int source , int destination){  // this is used to add undirected graph
        graph.get(source).add(destination);
    } 
    public void add_bidirectional(int source , int destination){ // this is used to add directed graph
        graph.get(source).add(destination); 
        graph.get(destination).add(source);
    }
    public void dfs(int source){
        Stack<Integer> stack = new Stack<Integer>();
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
    
}