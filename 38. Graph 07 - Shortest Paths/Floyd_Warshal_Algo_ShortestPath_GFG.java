import java.util.*;
public class Floyd_Warshal_Algo_ShortestPath_GFG {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t--!=0) {
			
			int v = s.nextInt();
			
			int[][] graph = new int[v][v];
			s.nextLine();
			for(int i=0; i<v; i++) {
				String[] strarr = s.nextLine().split("\\s+");
				for(int j=0; j<v; j++) {
					if(!strarr[j].equals("INF")) 
						graph[i][j] = Integer.valueOf(strarr[j]);
					else
						graph[i][j] = Integer.MAX_VALUE/2;
				}
			}
			
			//display(graph);
			
			for(int i=0; i<v; i++) {
				
				for(int j=0;j<v; j++) {
					for(int k=0; k<v; k++) {
							graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
					}
				}
			}
			
			for(int i=0; i<v; i++) {
				for(int j=0; j<v; j++) {
					if(graph[i][j]>=10000000)
						System.out.print("INF"+" ");
					else
						System.out.print(graph[i][j]+" ");
				}
				System.out.println();
			}
			
		}

	}
	
	static void display(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}
	}

}
