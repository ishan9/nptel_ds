package nptel_ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

public class Sokoban {
	//Number of Vertices
	private int V;
	//Adjacency list
	private  Map<Integer, List<Integer>> Adjacency_List;
	
	Sokoban(int v) {
		V=v;
        Adjacency_List = new HashMap<Integer, List<Integer>>();	
	    for (int i = 1 ; i <= V ; i++) { 
	        Adjacency_List.put(i, new LinkedList<Integer>());
	    }
	}
	void setEdge(int source,  int destination) {
        if (source > Adjacency_List.size() || destination > Adjacency_List.size()) {
	           System.out.println("the vertex entered in not present ");
	           return;
	    }
	    List<Integer> slist = Adjacency_List.get(source);
        slist.add(destination);
	    List<Integer> dlist = Adjacency_List.get(destination);
        dlist.add(source);
	}
	int calc_min_dist(int su, int d) {
		boolean visited[] = new boolean[V+1];
		int parent[] = new int[V+1];
		int dist[] = new int[V+1];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[su]= true;
		queue.add(su);
		dist[su] = 0;
		int s;
		while (queue.size() != 0) {
			s=queue.poll();
			
			List<Integer> list = Adjacency_List.get(s);
			ListIterator<Integer> i = list.listIterator(); 
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					parent[n]=s;
					dist[n] = dist[s]+1;
					visited[n] =true;
					queue.add(n);
				}
				if(visited[d]==true) {
					break;
				}
			}
		}
		return dist[d];
	}
	public static void  main(String args[]) {
		int rows, columns;

		Scanner scan = new Scanner(System.in);
		rows = scan.nextInt();
		columns = scan.nextInt();
      
        int vertices = rows * columns;
        Sokoban adjacencyList = new Sokoban(vertices);

        int i,j,k;
        int target_i;
        int target_j;
        int box_i;
        int box_j;
        int sokoban_i;
        int sokoban_j;
        int target=0;
        int box=0;
        int sokoban=0;
        k=1;
        int [][]tmp = new int[rows][columns];
        for (i = 0; i<rows;i++) {
     	    for(j = 0;j<columns;j++) {
     		    tmp[i][j] = k++;
     	    }   
        }
        char [][]grid = new char[rows][columns];
        for (i=0;i<rows;i++){
        	String str = scan.next();
            for(j=0;j<columns;j++) {
                grid[i][j] = str.charAt(j);
                }
            }
        for (i=0;i<rows;i++) {
            for(j=0;j<columns;j++) {
                if (grid[i][j] != '#') {
                	if(grid[i][j] == 'T') {
                		target = tmp[i][j];
                		target_i=i;
                		target_j=j;
                	}
                	if(grid[i][j] == 'B') {
                		box = tmp[i][j];
                		box_i=i;
                		box_j=j;                		
                	}
                	if(grid[i][j] == 'S') {
                		sokoban = tmp[i][j];
                		sokoban_i=i;
                		sokoban_j=j;                		
                	}
                	if (i+1 <rows && grid[i+1][j] != '#') {
                        //System.out.println("Add Edge between "+tmp[i][j]+" and "+tmp[i+k][j]);
                        adjacencyList.setEdge(tmp[i][j],tmp[i+1][j]);
                	}
                	if (j+1<columns && grid[i][j+1] != '#') {
                        //System.out.println("Add Edge between "+tmp[i][j]+" and "+tmp[i+k][j]);
                        adjacencyList.setEdge(tmp[i][j],tmp[i][j+1]);
                	}
                }
            }
        }
        //System.out.println("Source and Destination"+source_cell+" "+destination_cell);
        System.out.println(adjacencyList.calc_min_dist(target,box));
        System.out.println(adjacencyList.calc_min_dist(box,sokoban)-1);
       // System.out.println("Target Box Sokoban:"+target+" "+box+" "+sokoban);
       // scan.close();
	}
}
