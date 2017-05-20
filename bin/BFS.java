package nptel_ds;
import java.util.*;

public class BFS {
    private int V;
    private Map<Integer , LinkedList<Integer>> AdjList;
    BFS(int v) {
    	V=v;
    	AdjList= new HashMap<Integer, LinkedList<Integer>>();
    	for(int i =1;i<=V;i++) {
    		AdjList.put(i, new LinkedList<Integer>());
    	}
    }
    void addEdge(int v1, int v2) {
    	LinkedList<Integer> v1list = AdjList.get(v1);
    	v1list.add(v2);
    	LinkedList<Integer> v2list = AdjList.get(v2);
    	v2list.add(v1);    	
    }
    void tracePath(){
    	
    }
    void show() {
        for(int i=1;i<=V;i++) {
            LinkedList<Integer> n = AdjList.get(i);
            System.out.print(i+":");
            for(int j:n) {
            	System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main (String[] args) {
    	BFS aj = new BFS(5);
    	aj.addEdge(1, 2);
    	aj.addEdge(1, 3);
    	aj.addEdge(2, 4);
    	aj.addEdge(3, 5);
    	aj.addEdge(4, 5);
    	aj.show();
    } 
}
