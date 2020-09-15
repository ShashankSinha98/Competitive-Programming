import java.util.*;

class Data{
	int a;
	int b;
	int cost;
	
	Data(int a, int b, int cost){
		this.a = a;
		this.cost = cost;
		this.b = b;
	}
}


public class Bellman_Ford_Shortest_Path {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t= s.nextInt();
		
		s.nextLine();
		while(t--!=0) {
			
			String[] strarr = s.nextLine().split("\\s+");
			
			int V = Integer.valueOf(strarr[0]);
			int E = Integer.valueOf(strarr[1]);
			
			int[] dist = new int[V];
			
			
			for(int i=0; i<V; i++) {
				dist[i] = Integer.MAX_VALUE/2;
			}
			dist[0] = 0;
			ArrayList<Data> arr = new ArrayList<>();
			strarr = s.nextLine().split("\\s+");
			
			for(int i=0; i<E; i++) {
				int a = Integer.valueOf(strarr[3*i]);
				int b = Integer.valueOf(strarr[3*i+1]);
				int cost = Integer.valueOf(strarr[3*i+2]);
				arr.add(new Data(a, b, cost));
			}
			
			boolean changed = false;
			for(int i=0; i<V; i++) {
				changed = false;
				
				for(Data d : arr) {
					
					int a = d.a;
					int b = d.b;
					int w = d.cost;
					
					if(dist[a]+w<dist[b]) {
						changed = true;
						dist[b] = dist[a]+w; 
					}
				}
				if(changed == false) {
					System.out.println("0");
					break;
				}else if(i==V-1) {
					System.out.println("1");
					break;
				}
				
				//display(dist);
			}
			
		}
		
	
		
		

	}
	
	
	static void display(int[] arr) {
		for(int i : arr) {
			System.out.print(i+", ");
		}
		System.out.println();
	}

	
	
}


