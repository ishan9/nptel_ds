package nptel_ds;

import java.util.Scanner;
import java.util.*;

class GraphSol {
	//Number of Vertices
	private int V;
	//Adjacency list
	private  Map<Integer, LinkedList<Integer>> Adjacency_List;
	
	GraphSol(int v) {
		V=v;
        Adjacency_List = new HashMap<Integer, LinkedList<Integer>>();	
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
		int source_cell , destination_cell;
		int rows, columns;

		Scanner scan = new Scanner(System.in);
		rows = scan.nextInt();
		columns = scan.nextInt();
      
        int vertices = rows * columns;
        source_cell = 1;
        destination_cell = vertices;
        GraphSol adjacencyList = new GraphSol(vertices);

        int i,j,k;
        k=1;
        int [][]tmp = new int[rows][columns];
        for (i = 0; i<rows;i++) {
     	    for(j = 0;j<columns;j++) {
     		    tmp[i][j] = k++;
     	    }   
        }

        for (i=0;i<rows;i++){
            for(j=0;j<columns;j++) {
                int x = scan.nextInt();
                k=1;
                while(k<=x && k+j <columns) {
                    //System.out.println("Add Edge between "+tmp[i][j]+" and "+tmp[i][j+k]);
                    adjacencyList.setEdge(tmp[i][j],tmp[i][j+k]);
                    k++;
                }
            }
        }
        for (i=0;i<rows;i++) {
            for(j=0;j<columns;j++) {
                int x = scan.nextInt();
                k=1;
                while(k<=x && k+i<rows){
                    //System.out.println("Add Edge between "+tmp[i][j]+" and "+tmp[i+k][j]);
                    adjacencyList.setEdge(tmp[i][j],tmp[i+k][j]);
                    k++;
                }
            }
        }
        //System.out.println("Source and Destination"+source_cell+" "+destination_cell);
        System.out.println(adjacencyList.calc_min_dist(source_cell,destination_cell));
        scan.close();
	}
}