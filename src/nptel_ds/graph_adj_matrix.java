package nptel_ds;
import java.util.Scanner;

public class graph_adj_matrix {
	public static void main() {
		int M,N;
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int count = 0;
		int adj[][] = new int[M][N];
		for (int i = 0; i<M;i++) {
			for (int j=0;j<N;j++) {
				adj[i][j] = count++;
			}
		}
		for (int i = 0; i<M;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(adj[i][j]);
			}
			System.out.println();
		}	
	}
}
