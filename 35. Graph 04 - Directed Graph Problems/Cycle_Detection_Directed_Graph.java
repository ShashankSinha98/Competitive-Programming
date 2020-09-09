import java.util.*;
public class Cycle_Detection_Directed_Graph {
	
class Graph{
		
		ArrayList<ArrayList<Integer>> arr;
		int V;
		
		Graph(int V){
			this.V =V;
			this.arr = new ArrayList<>();
			for(int i=0;i<V;i++) {
				arr.add(new ArrayList<>());
			}
		}
		
		public void add_edge(int x, int y) {
			this.arr.get(x).add(y);
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
		
		public boolean dfs_helper(int node, int[] visited, int[] path) {
			visited[node] = 1;
			path[node] = 1;
			
			for(int c : this.arr.get(node)) {
				if(visited[c]==0) {
					boolean cycleMila =  dfs_helper(c, visited, path);
					if(cycleMila)
						return true;
					
				} else if(visited[c]==1 && path[c]==1) {
					return true;
				}
			}
			path[node] = 0;
			return false;
		}
		
		public void display_arr(int[] arr) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+", ");
			}
			System.out.println();
		}
		
		public boolean detect_cycle() {
			int[] visited = new int[this.V];
			int[] path = new int[this.V];
			
			for(int i=0; i<this.V; i++) {
				if(visited[i]==0) {
					boolean res = dfs_helper(i,visited,path);
					if(res)
						return true;
			}
			}
			return false;
		}

}
	


public static void main(String[] args) {
	
	Graph g = new Cycle_Detection_Directed_Graph().new Graph(7);
	
	g.add_edge(0, 1);
	g.add_edge(1, 2);
	g.add_edge(2, 3);
	g.add_edge(3, 4);
	g.add_edge(4, 5);
	g.add_edge(1, 5);
	g.add_edge(5, 6);
	g.add_edge(4, 2);
	
	System.out.println(g.detect_cycle());
		
}

}
