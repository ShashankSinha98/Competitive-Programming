import java.util.ArrayList;


public class Cycle_Detection_Undirected_Graph {
	
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
				if(visited[c]==0) {

					boolean cycle_mila =  cycle_helper(c, visited, node);
					if(cycle_mila)
						return true;

				} else if(visited[c]==1 && c!=parent) {
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
		
		Graph g = new Cycle_Detection_Undirected_Graph().new Graph(5);
		
		g.add_edge(0, 1);
		g.add_edge(2, 1);
		g.add_edge(2, 3);
		g.add_edge(3, 4);
		g.add_edge(4, 0);
		
		System.out.println(g.contains_cycle());

	}

}
