import java.util.*;
public class DFS_Traversal_Graph {

	class Graph{
		
		
		int V;
		ArrayList<ArrayList<Integer>> arr;
		
		Graph(int V){
			this.V = V;
			this.arr = new ArrayList<>();
			for(int i=1; i<=V; i++)
				this.arr.add(new ArrayList<>());
		}
		
		public void add_edge(int x, int y) {
			this.arr.get(x).add(y);
			this.arr.get(y).add(x);
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
		
	public void dfs_helper(int node,int[] visited) {
		
		visited[node]=1;
		System.out.print(node+", ");
		
		for(int c : this.arr.get(node)) {
			if(visited[c]==0)
				dfs_helper(c, visited);
		}
	}
		
	public void dfs(int src) {
		
		int[] visited = new int[this.V];
		
		dfs_helper(src,visited);
	}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DFS_Traversal_Graph dfs_main = new DFS_Traversal_Graph();
		Graph g = dfs_main.new Graph(6);
		
		g.add_edge(0, 1);
		g.add_edge(0, 3);
		g.add_edge(2, 1);
		g.add_edge(2, 3);
		g.add_edge(4, 3);
		g.add_edge(4, 5);
		
		g.display();
		
		g.dfs(0);

	}

}
