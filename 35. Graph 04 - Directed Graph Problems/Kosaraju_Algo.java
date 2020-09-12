import java.util.*;

public class Kosaraju_Algo {

	class KosarajuGraph {

		ArrayList<ArrayList<Integer>> graph;
		ArrayList<ArrayList<Integer>> reverse_graph;
		int V;

		KosarajuGraph(int V) {
			this.V = V;
			this.graph = new ArrayList<>();
			this.reverse_graph = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				graph.add(new ArrayList<>());
				reverse_graph.add(new ArrayList<>());
			}
		}

		public void add_edge(int x, int y) {
			this.graph.get(x).add(y);
			this.reverse_graph.get(y).add(x);
		}

		public void getStronglyConnectedComponents() {
			
			Stack<Integer> st = new Stack<>();
			int[] visited = new int[this.V];
			
			for(int i=0; i<this.V; i++) {
				if(visited[i]==0)
				dfs_helper(i,visited,st);
			}
			
			visited = new int[this.V];
			
			int col=0;
			while(!st.isEmpty()) {
				int curr = st.pop();
				if(visited[curr]==0) {
					col+=1;
					dfs_mark_components(curr,col,visited);
			}
			}
			
			for(int i=0; i<this.V; i++) {
				
				System.out.println(i+" -> "+visited[i]);
			}
			System.out.println("Count : "+col);
			
		}
		
		public void dfs_mark_components(int curr, int col,int[] visited) {
			
			visited[curr] = col;
			
			for(int c : this.reverse_graph.get(curr)) {
				if(visited[c]==0)
					dfs_mark_components(c, col, visited);
			}
			
		}

		public void dfs_helper(int node, int[] visited, Stack<Integer> st) {
			visited[node] = 1;
			for (int c : this.graph.get(node)) {
				if (visited[c] == 0) {
					dfs_helper(c, visited, st);
					
				}
			}
			st.add(node);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KosarajuGraph g = new Kosaraju_Algo().new KosarajuGraph(6);
		g.add_edge(0, 1);
		g.add_edge(1, 2);
		g.add_edge(2, 0);
		g.add_edge(2, 3);
		g.add_edge(3, 4);
		g.add_edge(4, 5);
		g.add_edge(5, 3);
		
		g.getStronglyConnectedComponents();

	}

}
