package nptel_ds;

import java.util.Scanner;

public class Best {
    public static void main (String args[]) {
    	Scanner sc=new Scanner(System.in);
    	int N = sc.nextInt();
    	int A[] = new int[N];
    	for (int i=0;i<N;i++) {
    		A[i] = sc.nextInt();
    	}
    	sc.close();
    	int best[] = new int [N];
    	best[N-1]= 1;
    	int i;
    	int j;
    	for(i=N-2;i>=0;i--) {
    		best[i]=1;
    		for(j=i+1;j<N;j++) {
    			if (A[i] < A[j] && A[j] % A[i] ==0) {
    				int max = 1+best[j];
    				if(max>best[i]){
    				    best[i]=max;
    				}
    			}
    		}
    	}
    	int max_val=best[0];
    	for(int k=1;k<N;k++) {
    		if(max_val < best[k]) {
    			max_val=k;
    		}
    	}
    	System.out.println(max_val);
    }
}

