import java.util.List;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
public class weighted_graph_using_class {
	public static void main(String art[]) {
		graph graph1 = new graph(7);
		graph1.add(0, 1, 10);
		graph1.add(1, 2, 10);
		graph1.add(2, 3, 10);
		graph1.add(0, 3, 49);
		graph1.add(3, 4, 10);
		graph1.add(4, 5, 3);
		graph1.add(5, 6, 3);
		graph1.add(4, 6, 8);
		graph1.bfs(0);
	}
}

class graph{
	int nodes;
	List<List<graph_container>> container;
	boolean visited[];
	graph(int nodes){
		this.nodes = nodes;
		container = new LinkedList<>();
		for(int i = 0; i < nodes; i++) {
			container.add(i , new LinkedList<graph_container>());
		}
		visited = new boolean[nodes];
		Arrays.fill(visited, false);
	}
	public void add(int source , int destination, int weight) {
		container.get(source).add(new graph_container( destination , weight));
		container.get(destination).add(new graph_container(source , weight));
	}
	public void bfs(int source) {
		Arrays.fill(visited, false);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		while(!queue.isEmpty()) {
			Integer pop= queue.poll();
			System.out.println(pop);
			List<graph_container> lists = container.get(pop);
			for(graph_container children: lists) {
				if(!visited[children.destination]) {
					visited[children.destination] = true;
					queue.add(children.destination);
				}
			}
		}
		
	}
	public void dfs(int source) {
		Arrays.fill(visited, false);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		visited[source] = true;
		while(!stack.isEmpty()) {
			Integer pop = stack.pop();
			System.out.println(pop);
			List<graph_container> child =container.get(pop);
			for(graph_container children : child) {
				if(!visited[children.destination]) {
					stack.push(children.destination);
					visited[children.destination] = true;
				}
			}
		}
	}
	static class graph_container{
		int weight;
//		int source;
		int destination;
		public graph_container(int destination, int weight) {
			this.weight = weight;
//			this.source = source;
			this.destination = destination;
		}
	}
	
}