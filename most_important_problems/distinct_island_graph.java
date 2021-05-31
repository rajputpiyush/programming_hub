//  famous question based on graph dfs search
// here a given 2d matrix which represent a graph where 0 represent island connectivity and 1 represent water
// you want to find a how many island is present in matrix / graph.
// island are connected vertically and horizontally only not diagonal connected 
// ex this is a valid island -- 0 0 
                         //   0 0
                             // 0 0
// so count will be increase to one

public class distinct_island_graph{
    public static void main(String [] args){
    	int graph [][] ={{0, 0, 0, 0, 1}, // created a two dimensional matrix
    					 {1, 1, 1, 1, 0},
    					 {0, 0, 1, 0, 0},
    					 {0, 1, 0, 1, 0},
    					 {1, 0, 1, 0, 0},
    					};
    	System.out.println(get_islands(graph)); // call a get_islands function and print the output
    }
    public static int get_islands(int graphs [][]) {
    	int count = 0;
    	boolean visited [][] = new boolean[graphs.length][graphs[0].length];
    	for(int i = 0; i < graphs.length; i++) {
    		for(int j = 0; j < graphs[0].length; j++) {
    			if(graphs[i][j] == 0 && visited[i][j] != true) {
    				get_islands(i , j, graphs , visited);
    				count++;
    			}
    		}
    	}
    	return count;
    }
    public static void get_islands(int i, int j, int graphs[][] , boolean visited[][]) {
    	
    	if(check(i , j, visited , graphs)) {
    		visited[i][j] = true;
    		get_islands(i , j + 1 , graphs , visited); // recursion used 
    		get_islands(i , j - 1, graphs , visited);
    		get_islands(i + 1, j, graphs , visited);
    		get_islands(i -1 , j , graphs , visited);
    	}
    }
    // used check funtion to check that this is a valid position in matrix or not
    public static boolean check(int i , int j , boolean visited[][] , int graphs[][]) {
    	if((j >= visited.length || j < 0) || (i >= visited.length || i < 0)) {
    		return false;
    	}
    	else if(visited[i][j] == true || graphs[i][j] == 1) {
    		return false;
    	}
    	return true;
    }

    
}