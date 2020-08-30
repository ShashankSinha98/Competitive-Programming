import java.util.*;

class GraphCCUG{
	int V;
	ArrayList<ArrayList<Integer>> arr;
	
	public GraphCCUG(int V) {
		this.V = V;
		this.arr = new ArrayList<>();
		for(int i=0; i<V; i++)
			arr.add(new ArrayList<>());
	}
	
	public void add_edge(int v1, int v2) {
		this.arr.get(v1).add(v2);
		this.arr.get(v2).add(v1);
	}
	
	public void display() {
		for(int i=0; i<this.V; i++) {
			System.out.print(i+"");
			ArrayList<Integer> list = this.arr.get(i);
			
			for(int j : list) {
				System.out.print(" -> "+j);
			}
			System.out.println();
		}
	}

	public void print_components() {
		int[] visited = new int[this.V];
		
		int cnt = 0;
		for(int i=0; i<this.V; i++) {
			if(visited[i]==0) {
				System.out.print("Component: "+(++cnt)+" --> ");
				traverse_dfs(i,visited);
				System.out.println();
			}
		}
	}
	
	public void traverse_dfs(int st, int[] visited) {
		
		System.out.print(st+", ");
		visited[st] = 1;
		ArrayList<Integer> list = this.arr.get(st);
		
		
		for(int i=0; i<list.size(); i++) {
			if(visited[list.get(i)]==0) {
				traverse_dfs(list.get(i), visited);
			}
		}
	}
}

public class ConnectedComponentsUndirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphCCUG g = new GraphCCUG(9);
		
		g.add_edge(0, 1);
		g.add_edge(1, 2);
		g.add_edge(2, 3);
		g.add_edge(0, 3);
		g.add_edge(0, 4);
		
		g.add_edge(5, 6);
		g.add_edge(6, 7);
		
		g.add_edge(8, 8);
		
		g.print_components();
		
		

	}

}
