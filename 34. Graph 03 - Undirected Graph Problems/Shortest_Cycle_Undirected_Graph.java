import java.util.*;

class Graph2{
	
	ArrayList<ArrayList<Integer>> arr;
	int V;
	
	Graph2(int V){
		this.V =V;
		this.arr = new ArrayList<>();
		for(int i=0;i<V;i++) {
			arr.add(new ArrayList<>());
		}
	}
	
	public void add_edge(int x, int y) {
		this.arr.get(x).add(y);
		this.arr.get(y).add(x);
	}
	
	public int shortest_cycle() {
		
		int[] dist = new int[V];
		int[] visited = new int[V];
		
		Queue<Integer> q = new LinkedList<>();
		int cycle = Integer.MAX_VALUE;
		
		for(int node=0;node<V;node++) {
			dist = new int[V];
			visited = new int[V];
			
			visited[i] = 1;
			
			q.add(node);
			int d=0;
			while(!q.isEmpty()) {
				d+=1;
				int rem = q.remove();
				for(int child : this.arr.get(rem)) {
					
					
					if (visited[child]!=1) {
					q.add(child);
					dist[child] = d;
					visited[child] = 1;
					} else {
						
						if(dist[child]>=dist[rem]) {
							cycle = Math.min(cycle, dist[rem]+dist[child]+1);
						}
					}
					
				}
			}
			
		}
		
		return cycle;
	}
	
	 void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}
	 
		
		public void display() {
			
			for(int i=0; i<V; i++) {
				System.out.print(String.valueOf(i));
				
				for(int j=0;j<this.arr.get(i).size(); j++) {
					System.out.print(" -> "+this.arr.get(i).get(j));
				}
				System.out.println();
			}
		}
}


public class Shortest_Cycle_Undirected_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph2 g = new Graph2(7);
		g.add_edge(0, 6);
		g.add_edge(0, 5);
		g.add_edge(1, 5);
		g.add_edge(1, 6);
		g.add_edge(2, 6);
		g.add_edge(3, 4);
		g.add_edge(4, 1);
		g.add_edge(3, 2);
		g.add_edge(2, 1);
		
		//g.display();
		
		System.out.println(g.shortest_cycle());


	}

}
