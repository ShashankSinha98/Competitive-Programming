import java.util.*;

public class Bipartite_Graph {
	
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
		
		public boolean cycle_helper(int node,int[] visited, int parent) {
			
			visited[node] = 1;
			for(int c : this.arr.get(node)) {
				if(visited[c]!=1) {
					return cycle_helper(c, visited, node);
				} else if(c!=parent) {
					return true;
				}
			}
			return false;
			
		}
		
		public boolean contains_cycle() {
			int[] visited = new int[this.V];
			
			return cycle_helper(0,visited,-1);
		}
		
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0};
		
		

	}

}
